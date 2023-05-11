package com.craftinginterpreters.lox;

class RPNPrinter implements Expr.Visitor<String> {

  String print(Expr expr) {
    return expr.accept(this);
  }

  @Override
  public String visitBinaryExpr(Expr.Binary expr) {
    return expr.left.accept(this) + " "
      + expr.right.accept(this) + " "
      + expr.operator.lexeme;
  }

  @Override
  public String visitGroupingExpr(Expr.Grouping expr) {
    return expr.expression.accept(this);
  }

  @Override
  public String visitLiteralExpr(Expr.Literal expr) {
    if (expr.value == null) return "nil";
    return expr.value.toString();
  }

  @Override
  public String visitUnaryExpr(Expr.Unary expr) {
    return expr.right.accept(this) + " " + expr.operator.lexeme;
  }

  public static void main(String[] args) {
    // 2+2*3
    Expr pemdas = new Expr.Binary(
      new Expr.Literal("2"),
      new Token(TokenType.PLUS, "+", null, 1),
      new Expr.Binary(
        new Expr.Literal("2"),
        new Token(TokenType.STAR, "*", null, 1),
        new Expr.Literal("3")
        )
    );

    // (-2+2)*3
    Expr parens = new Expr.Binary(
      new Expr.Literal("3"),
      new Token(TokenType.STAR, "*", null, 1),
      new Expr.Binary(
        new Expr.Unary(new Token(TokenType.MINUS, "-", null, 1), new Expr.Literal("2")),
        new Token(TokenType.PLUS, "+", null, 1),
        new Expr.Literal("2")
        )
    );

    // 2+2
    Expr trivial = new Expr.Binary(
      new Expr.Literal("2"),
      new Token(TokenType.STAR, "+", null, 1),
      new Expr.Literal("2")
    );

    System.out.println(new RPNPrinter().print(pemdas));
  }
}

