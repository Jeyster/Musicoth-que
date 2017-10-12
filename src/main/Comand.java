package main;

import java.io.IOException;

public interface Comand {

    String getName();

    void execute() throws IOException;

}
