EXE=Main.jar
ENTRYPOINT=com.craftinginterpreters.lox.Lox
OBJS=com/craftinginterpreters/lox/AstPrinter.class com/craftinginterpreters/lox/Expr$$Binary.class\
		 com/craftinginterpreters/lox/Expr$$Grouping.class com/craftinginterpreters/lox/Expr$$Literal.class\
		 com/craftinginterpreters/lox/Expr$$Unary.class com/craftinginterpreters/lox/Expr$$Visitor.class\
		 com/craftinginterpreters/lox/Expr.class com/craftinginterpreters/lox/Interpreter.class\
		 com/craftinginterpreters/lox/Lox.class com/craftinginterpreters/lox/Parser.class\
		 com/craftinginterpreters/lox/Parser$$ParseError.class com/craftinginterpreters/lox/Parser.class\
		 com/craftinginterpreters/lox/RPNPrinter.class com/craftinginterpreters/lox/RuntimeError.class\
		 com/craftinginterpreters/lox/Scanner.class com/craftinginterpreters/lox/Token.class\
		 com/craftinginterpreters/lox/Stmt.class com/craftinginterpreters/lox/Stmt$$Print.class\
		 com/craftinginterpreters/lox/Stmt$$Expression.class com/craftinginterpreters/lox/Stmt$$Visitor.class\
		 com/craftinginterpreters/lox/Parser$$1.class com/craftinginterpreters/lox/TokenType.class\
		 com/craftinginterpreters/lox/Interpreter$$1.class


$(EXE): $(OBJS)
	jar cfe Main.jar com.craftinginterpreters.lox.Lox $(subst $,\$,$^)

%.class: %.java
	javac -g $?

run: $(EXE)
	java -jar  $(EXE)

rlwrap: $(EXE)
	rlwrap java -jar $(EXE)

# leave any initialization commands in .jdbrc
debug: $(EXE)
	rlwrap jdb $(ENTRYPOINT)

clean: 
	- rm com/craftinginterpreters/lox/*.class

.PHONY: clean run rlwrap debug
