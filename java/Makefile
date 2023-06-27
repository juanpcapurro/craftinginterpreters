EXE=Main.jar
ENTRYPOINT=com.craftinginterpreters.lox.Lox
ENUM_USING_OBJS=com/craftinginterpreters/lox/Parser$$1.class com/craftinginterpreters/lox/Interpreter$$1.class com/craftinginterpreters/lox/Interpreter$$2.class com/craftinginterpreters/lox/Resolver$$FunctionType.class

STATIC_EXPR_OBJS=com/craftinginterpreters/lox/Expr$$Binary.class com/craftinginterpreters/lox/Expr$$Grouping.class \
								com/craftinginterpreters/lox/Expr$$Literal.class com/craftinginterpreters/lox/Expr$$Unary.class \
								com/craftinginterpreters/lox/Expr$$Visitor.class com/craftinginterpreters/lox/Expr$$Variable.class \
								com/craftinginterpreters/lox/Expr$$Assign.class com/craftinginterpreters/lox/Expr$$Logical.class\
								com/craftinginterpreters/lox/Expr$$Call.class


STATIC_STMT_OBJS=com/craftinginterpreters/lox/Stmt$$Print.class com/craftinginterpreters/lox/Stmt$$Var.class \
								com/craftinginterpreters/lox/Stmt$$Expression.class com/craftinginterpreters/lox/Stmt$$Visitor.class \
								com/craftinginterpreters/lox/Stmt$$Block.class com/craftinginterpreters/lox/Stmt$$If.class \
								com/craftinginterpreters/lox/Stmt$$While.class com/craftinginterpreters/lox/Stmt$$Function.class\
								com/craftinginterpreters/lox/Stmt$$Return.class com/craftinginterpreters/lox/Return.class


OBJS=com/craftinginterpreters/lox/Expr.class com/craftinginterpreters/lox/Interpreter.class\
		 com/craftinginterpreters/lox/Lox.class com/craftinginterpreters/lox/Parser.class\
		 com/craftinginterpreters/lox/Parser$$ParseError.class com/craftinginterpreters/lox/Stmt.class \
		  com/craftinginterpreters/lox/RuntimeError.class\
		 com/craftinginterpreters/lox/Scanner.class com/craftinginterpreters/lox/Token.class\
		 com/craftinginterpreters/lox/TokenType.class com/craftinginterpreters/lox/Environment.class\
		 com/craftinginterpreters/lox/LoxCallable.class com/craftinginterpreters/lox/LoxFunction.class\
		 com/craftinginterpreters/lox/Resolver.class\
		 $(ENUM_USING_OBJS) $(STATIC_STMT_OBJS) $(STATIC_EXPR_OBJS)


$(EXE): $(OBJS)
	@jar cfe Main.jar com.craftinginterpreters.lox.Lox $(subst $,\$,$^)

%.class: %.java
	javac -g $?

com/craftinginterpreters/lox/Expr$$%.class: com/craftinginterpreters/lox/Expr.java
	javac -g $?

com/craftinginterpreters/lox/Resolver$$FunctionType.class: com/craftinginterpreters/lox/Resolver.java
	javac -g $?

com/craftinginterpreters/lox/Stmt$$%.class: com/craftinginterpreters/lox/Stmt.java
	javac -g $?

run: $(EXE)
	java -jar  $(EXE)

runprog: $(EXE)
	java -jar  $(EXE) prog.lox

rlwrap: $(EXE)
	rlwrap java -jar $(EXE)

# leave any initialization commands in .jdbrc
debug: $(EXE)
	rlwrap jdb $(ENTRYPOINT)

generate-ast: com/craftinginterpreters/tool/GenerateAst.class
	java com.craftinginterpreters.tool.GenerateAst com/craftinginterpreters/lox

clean: 
	- rm com/craftinginterpreters/lox/*.class

.PHONY: clean run rlwrap debug
