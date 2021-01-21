package cloudblue.utility;

public interface PaginationAnnotation<T> {
    public T next();
    public T previous();
    public T moveTo(int page_number);
    public int totalPage();
    public int currentPage();
}
