public class OrderMatic implements Runnable{
    private int orderNo;

    public OrderMatic() {
        this.orderNo = 0;
    }

    @Override
    public void run() {
            try {
                Thread.sleep(2000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }

        this.orderNo++;
        System.out.println("Thread : " + Thread.currentThread().getName() + "- OrderNo: " + getOrderNo());
    }

    public int getOrderNo() {
        return orderNo;
    }

    public void setOrderNo(int orderNo) {
        this.orderNo = orderNo;
    }

    @Override
    public String toString() {
        return "OrderMatic{" +
                "orderNo=" + orderNo +
                '}';
    }
}
