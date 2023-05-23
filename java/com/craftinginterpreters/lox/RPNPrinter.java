package com.craftinginterpreters.lox;

import java.util.List;

class RPNPrinter implements Expr.Visitor<String>, Stmt.Visitor<String> {

  String print(List<Stmt> statements) {
    String result = "";
    for (Stmt statement : statements) {
      result = result + statement.accept(this);
    }
    return result;
  }

  @Override
  public String visitExpressionStmt(Stmt.Expression stmt) {
    return stmt.expression.accept(this) + " ;\n";
  }

  @Override
  public String visitPrintStmt(Stmt.Print stmt) {
    return stmt.expression.accept(this) + " print\n";
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
    return expr.right.accept(this) + " " + (expr.operator.lexeme.equals("-") ? "~" : expr.operator.lexeme);
  }
}

