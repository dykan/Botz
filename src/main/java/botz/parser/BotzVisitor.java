package botz.parser;

import japa.parser.ast.ImportDeclaration;
import japa.parser.ast.body.BodyDeclaration;
import japa.parser.ast.body.ClassOrInterfaceDeclaration;
import japa.parser.ast.body.MethodDeclaration;
import japa.parser.ast.body.ModifierSet;
import japa.parser.ast.body.Parameter;
import japa.parser.ast.expr.AssignExpr;
import japa.parser.ast.expr.BinaryExpr;
import japa.parser.ast.expr.Expression;
import japa.parser.ast.expr.FieldAccessExpr;
import japa.parser.ast.expr.NameExpr;
import japa.parser.ast.expr.AssignExpr.Operator;
import japa.parser.ast.expr.ThisExpr;
import japa.parser.ast.stmt.BlockStmt;
import japa.parser.ast.stmt.ReturnStmt;
import japa.parser.ast.stmt.Statement;
import japa.parser.ast.type.ClassOrInterfaceType;
import japa.parser.ast.visitor.GenericVisitorAdapter;
import japa.parser.ast.visitor.VoidVisitorAdapter;

import java.util.ArrayList;
import java.util.List;

import botz.cstree.AssignNode;
import botz.cstree.BlockContainerNode;
import botz.cstree.ClassNode;
import botz.cstree.CodeNode;
import botz.cstree.CoffeScriptRoot;
import botz.cstree.ImportNode;
import botz.cstree.MethodNode;
import botz.cstree.Node;
import botz.cstree.ParameterNode;
import botz.cstree.expression.DoubleExpressionNode;
import botz.cstree.expression.ExpressionNode;
import botz.cstree.expression.SimpleExpression;

public class BotzVisitor extends GenericVisitorAdapter<Node, Node> {

	CoffeScriptRoot root = new CoffeScriptRoot();

	public CoffeScriptRoot getRoot() {
		return root;
	}

	@Override
	public Node visit(ClassOrInterfaceDeclaration declaration, Node parent) {
		String className = declaration.getName();
		String parentClass = null;
		ArrayList<String> interfaces = new ArrayList<String>();
		ArrayList<ParameterNode> members = new ArrayList<ParameterNode>();

		if (declaration.getExtends() != null) {
			parentClass = declaration.getExtends().get(0).getName();
		}

		if (declaration.getImplements() != null) {
			for (ClassOrInterfaceType curr : declaration.getImplements()) {
				interfaces.add(curr.getName());
			}
		}

		// todo: get members
		if (declaration.getMembers() != null) {
			for (BodyDeclaration bodyDeclaration : declaration.getMembers()) {

			}

		}

		if (declaration.isInterface()) {
			
		} else {
			ClassNode classNode = new ClassNode(root, className, parentClass,
					interfaces, members);
			root.setClassNode(classNode);
			super.visit(declaration, classNode);
		}
		
		return null;

	}

	@Override
	public Node visit(ImportDeclaration importDeclaration, Node parent){
		String strImport = importDeclaration.getName().toString();
		ImportNode importNode = new ImportNode(parent, strImport);
		root.addImport(importNode);
		return null;
	}
	@Override
	public Node visit(MethodDeclaration methodDec, Node parent) {
		String name = methodDec.getName();
		String returnType = (String) methodDec.getType().getData();
		int modifier = methodDec.getModifiers();
		boolean isPrivate = ModifierSet.isPrivate(modifier);
		boolean isStatic = ModifierSet.isStatic(modifier);
		ArrayList<ParameterNode> paramsNodes = new ArrayList<ParameterNode>();
		ArrayList<CodeNode> bodyNodes = new ArrayList<CodeNode>();
		MethodNode methodNode = new MethodNode(parent, name, returnType,
				paramsNodes, isStatic);

		// handle params
		List<Parameter> params = methodDec.getParameters();
		if (params != null) {
			for (Parameter param : params) {
				String type = (String) param.getType().getData();
				String id = param.getId().getName();

				ParameterNode paramNode = new ParameterNode(methodNode, type,id);
				paramsNodes.add(paramNode);
			}
		}

		((ClassNode) parent).addMethod(methodNode);

		super.visit(methodDec, methodNode);
		return null;
	}
	
	@Override
	public Node visit(AssignExpr assignExpr, Node parent){
		String target = assignExpr.getTarget().toString();
		ExpressionNode value = (ExpressionNode) assignExpr.getValue().accept(this, parent);
		Operator operation = assignExpr.getOperator();
		
		AssignNode assignNode = new AssignNode(parent, target, value);
		return assignNode;
	}
	
	@Override
	public Node visit(BinaryExpr binaryExpr, Node parent){
		ExpressionNode leftNode = (ExpressionNode) binaryExpr.getLeft().accept(this, parent);
		ExpressionNode rightNode = (ExpressionNode) binaryExpr.getRight().accept(this, parent);
		japa.parser.ast.expr.BinaryExpr.Operator op = binaryExpr.getOperator();
		String strOperator = EnumConverter.convertOperator(op);
		return new DoubleExpressionNode(parent, leftNode, strOperator, rightNode);
	}
	
	private Node visit(Expression exp, Node parent) {
		throw new RuntimeException("method not impl");
	}

	@Override
	public Node visit(ReturnStmt returnStmt, Node parent){
		ExpressionNode returnNode = (ExpressionNode) returnStmt.getExpr().accept(this, parent);
		returnNode.setParent(parent);
		return returnNode;
	}
	
	public Node visit(FieldAccessExpr fieldAccessExpr, Node parent){
		String scope = "";
		if (fieldAccessExpr.getScope()!=null){
			scope = fieldAccessExpr.getScope().toString() + ".";
		}
		return new SimpleExpression(scope + fieldAccessExpr.getFieldExpr().getName());
	}
	
	@Override
	public Node visit(NameExpr exp, Node parent){
		// only if we called it
		if(parent != null){
			return new SimpleExpression(exp.getName());
		}
		
		return super.visit(exp, parent);
	}
	
	@Override 
	public Node visit(BlockStmt blockStmt, Node parent){
		
		 ArrayList<Node> nodeList = new ArrayList<Node>();
		 for (Statement statement : blockStmt.getStmts()){
			  Node node = statement.accept(this, parent);
			  // if we didnt implement yet, it is null
			  if (node != null){
				  nodeList.add(node);
			  }

		 }
		 ((BlockContainerNode)parent).setBlock(nodeList);
		 return parent;
	}
	
	
//	@Override 
	//public Node visit()

}
