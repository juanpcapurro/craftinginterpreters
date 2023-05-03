EXE=Main.jar
ENTRYPOINT=com.craftinginterpreters.lox.Lox

$(EXE): com/craftinginterpreters/lox/*.class
	jar cfe Main.jar com.craftinginterpreters.lox.Lox $^

%.class: %.java
	javac $?

run: $(EXE)
	java -jar  $(EXE)

rlwrap: $(EXE)
	rlwrap java -jar $(EXE)

# leave any initialization commands in .jdbrc
debug: $(EXE)
	rlwrap jdb $(ENTRYPOINT)

clean: 
	- rm com/craftinginterpreters/lox/*.class
