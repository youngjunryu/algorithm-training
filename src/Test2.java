import java.util.*;

class UserSolution
{
    ArrayList<ArrayList<Order>> buyingList;
    ArrayList<ArrayList<Order>> sellingList;
    ArrayList<ArrayList<Integer>> fillPriceList;
    HashMap<Integer, Order> map;

    public void init()
    {
        buyingList = new ArrayList<>();
        sellingList = new ArrayList<>();
        fillPriceList = new ArrayList<>();
        map = new HashMap<>();

        for(int i = 0; i < 6; i++) {
            buyingList.add(new ArrayList<>());
            sellingList.add(new ArrayList<>());
            fillPriceList.add(new ArrayList<>());
        }
    }

    public int buy(int mNumber, int mStock, int mQuantity, int mPrice)
    {
        Order b = new Order(mNumber, mStock, mQuantity, mPrice);

        int sellingListSize = sellingList.get(mStock).size();

        for(int i = 0; i < sellingListSize; i++) {
            if(sellingList.get(mStock).isEmpty()) {
                break;
            }

            if(b.mPrice >= sellingList.get(mStock).get(0).mPrice) {
                fillPriceList.get(mStock).add(sellingList.get(mStock).get(0).mPrice);
                if(b.mQuantity > sellingList.get(mStock).get(0).mQuantity) {
                    b.mQuantity -= sellingList.get(mStock).get(0).mQuantity;
                    map.remove(sellingList.get(mStock).get(0).mNumber);
                    sellingList.get(mStock).remove(0);
                } else if(b.mQuantity < sellingList.get(mStock).get(0).mQuantity) {
                    sellingList.get(mStock).get(0).mQuantity -= b.mQuantity;
                    return 0;
                } else {
                    map.remove(sellingList.get(mStock).get(0).mNumber);
                    sellingList.get(mStock).remove(0);
                    return 0;
                }
            }
        }
        buyingList.get(mStock).add(b);
        map.put(b.mNumber, b);
        Collections.sort(buyingList.get(mStock), new Order.BuyingSort());
        return b.mQuantity;
    }

    public int sell(int mNumber, int mStock, int mQuantity, int mPrice)
    {
        Order s = new Order(mNumber, mStock, mQuantity, mPrice);

        int buyingListSize = buyingList.get(mStock).size();

        for(int i = 0; i < buyingListSize; i++) {
            if(buyingList.get(mStock).isEmpty()) {
                break;
            }

            if(buyingList.get(mStock).get(0).mPrice >= s.mPrice) {
                fillPriceList.get(mStock).add(buyingList.get(mStock).get(0).mPrice);
                if(s.mQuantity > buyingList.get(mStock).get(0).mQuantity) {
                    s.mQuantity -= buyingList.get(mStock).get(0).mQuantity;
                    map.remove(buyingList.get(mStock).get(0).mNumber);
                    buyingList.get(mStock).remove(0);
                } else if(s.mQuantity < buyingList.get(mStock).get(0).mQuantity) {
                    buyingList.get(mStock).get(0).mQuantity -= s.mQuantity;
                    return 0;
                } else {
                    map.remove(buyingList.get(mStock).get(0).mNumber);
                    buyingList.get(mStock).remove(0);
                    return 0;
                }
            }
        }

        sellingList.get(mStock).add(s);
        map.put(s.mNumber, s);
        Collections.sort(sellingList.get(mStock), new Order.SellingSort());
        return s.mQuantity;
    }

    public void cancel(int mNumber)
    {
        if(map.get(mNumber) == null)
            return;

        buyingList.get(map.get(mNumber).mStock).remove(map.get(mNumber));
        sellingList.get(map.get(mNumber).mStock).remove(map.get(mNumber));
        map.remove(mNumber);
    }

    public int bestProfit(int mStock)
    {
        int profit = 0;
        int max = 0;
        for(int i = fillPriceList.get(mStock).size() - 1; i >= 0 ; i--) {
            if(fillPriceList.get(mStock).get(i) > max)
                max = fillPriceList.get(mStock).get(i);
            else {
                if(profit < max - fillPriceList.get(mStock).get(i))
                    profit = max - fillPriceList.get(mStock).get(i);
            }
        }
        return profit;
    }
}

class Order {
    int mNumber;
    int mStock;
    int mQuantity;
    int mPrice;

    Order(int mNumber, int mStock, int mQuantity, int mPrice) {
        this.mNumber = mNumber;
        this.mStock = mStock;
        this.mQuantity = mQuantity;
        this.mPrice = mPrice;
    }

    public static class BuyingSort implements Comparator<Order> {
        @Override
        public int compare(Order o1, Order o2) {
            if(o1.mPrice > o2.mPrice)
                return -1;
            else if(o1.mPrice < o2.mPrice)
                return 1;
            else {
                if(o1.mNumber == o2.mNumber)
                    return 0;
                return o1.mNumber < o2.mNumber ? -1 : 1;
            }
        }
    }

    public static class SellingSort implements Comparator<Order> {
        @Override
        public int compare(Order o1, Order o2) {
            if(o1.mPrice > o2.mPrice)
                return 1;
            else if(o1.mPrice < o2.mPrice)
                return -1;
            else {
                if(o1.mNumber == o2.mNumber)
                    return 0;
                return o1.mNumber < o2.mNumber ? -1 : 1;
            }
        }
    }
}