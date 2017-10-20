public interface Model {
    void registerView(View gb);
    void reset();
    void update(int row, int col);
}
