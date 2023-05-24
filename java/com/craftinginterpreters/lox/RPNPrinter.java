package com.craftinginterpreters.lox;

import java.util.List;

class RPNPrinter implements Expr.Visitor<String>, Stmt.Visitor<String> {

  String print(List<Stmt> statements) {
    String result = "";
    for (Stmt statement : statements) {
      result = result + statement.accept(this) + "\n";
    }
    return result;
  }

  @Override
  public String visitBlockStmt(Stmt.Block stmt) {
    String result = "{\n";
    for (Stmt statement : stmt.statements) {
      result = result + statement.accept(this) + "\n";
    }
    result = result + "}";
    return result;
  }

  @Override
  public String visitAssignExpr(Expr.Assign expr){
    return expr.value.accept(this) + " " + expr.name.lexeme + " =";
  }

  @Override
  public String visitVarStmt(Stmt.Var stmt) {
    if(stmt.initializer != null){
      return stmt.initializer.accept(this) + " " + stmt.name.lexeme + " var-init";
    }
    return stmt.name.lexeme + " var";
  }

  @Override
  public String visitExpressionStmt(Stmt.Expression stmt) {
    return stmt.expression.accept(this) + " ;";
  }

  @Override
  public String visitPrintStmt(Stmt.Print stmt) {
    return stmt.expression.accept(this) + " print";
  }

  @Override
  public String visitVariableExpr(Expr.Variable expr) {
    return expr.name.lexeme;
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
    if (expr.value instanceof String) return "\"" + expr.value + "\"";
    return expr.value.toString();
  }

  @Override
  public String visitUnaryExpr(Expr.Unary expr) {
    return expr.right.accept(this) + " " + (expr.operator.lexeme.equals("-") ? "~" : expr.operator.lexeme);
  }
}

