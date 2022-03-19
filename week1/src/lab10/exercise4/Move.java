package lab10.exercise4;

public class Move {
    private int line;
    private int column;

    public Move(int line, int column) {
        this.line = line;
        this.column = column;
    }

    public int getLine() {
        return line;
    }

    public void setLine(int line) {
        this.line = line;
    }

    public int getColumn() {
        return column;
    }

    public void setColumn(int column) {
        this.column = column;
    }

    @Override
    public String toString() {
        return "Move{" +
                "line=" + line +
                ", column=" + column +
                '}';
    }
}
