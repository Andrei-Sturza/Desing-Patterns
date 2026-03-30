package ro.uvt.fi.dp;

public interface AccountCommand {
    void execute();
    void undo();
}
