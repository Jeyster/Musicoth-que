package main;

public class ExecuteContext {

    private Bibliotheque bibliotheque;

    public ExecuteContext(Bibliotheque bibliotheque) {
        this.bibliotheque = bibliotheque;
    }

    public Bibliotheque getBibliotheque() {
        return bibliotheque;
    }
}
