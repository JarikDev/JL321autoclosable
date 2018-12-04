package com;

public class Main {
    public static void main(String[] args) {
        try (MyClosable myClosable = new MyClosable()) {
            myClosable.doJob();
        } catch (Exception e) {
            Throwable[] throwables = e.getSuppressed();
            for (Throwable t : throwables) {
                System.out.println("supressed: "+t);
            }
        } finally {

        }
    }
}

class MyClosable implements AutoCloseable {
    public MyClosable() throws Exception {
        System.out.println("constructor");

    }

    void doJob() throws Exception {
        System.out.println("do job");
        throw new Exception("job exception");
    }

    @Override
    public void close() throws Exception {
        System.out.println("close");
        throw new Exception("exception");
    }
}




