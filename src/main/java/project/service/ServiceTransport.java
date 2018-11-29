package project.service;

public interface ServiceTransport<T> {
    public T getByTransport(T t);
}
