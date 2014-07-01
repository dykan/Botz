package botz.parser;

public class EnumConverter {

	public static String convertOperator(japa.parser.ast.expr.BinaryExpr.Operator op) {
		switch (op) {
		case or:
			return ("||");

		case and:
			return ("&&");

		case binOr:
			return ("|");

		case binAnd:
			return ("&");

		case xor:
			return ("^");

		case equals:
			return ("==");

		case notEquals:
			return ("!=");

		case less:
			return ("<");

		case greater:
			return (">");

		case lessEquals:
			return ("<=");

		case greaterEquals:
			return (">=");

		case lShift:
			return ("<<");

		case rSignedShift:
			return (">>");

		case rUnsignedShift:
			return (">>>");

		case plus:
			return ("+");

		case minus:
			return ("-");

		case times:
			return ("*");

		case divide:
			return ("/");

		case remainder:
			return ("%");

		}
		return null;

	}
}
