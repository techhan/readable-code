package cleancode.minesweeper.tobe.cell;

public interface Cell {




    boolean isLandMin();

    boolean hasLandMineCount();

    void flag();

    void open();

    boolean isChecked();

    boolean isOpened();

    CellSnapshot getSnapshot();
}
