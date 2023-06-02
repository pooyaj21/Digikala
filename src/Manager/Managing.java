package Manager;

import model.Goods;

import java.util.ArrayList;

 abstract class Managing {
    protected ArrayList<Goods> addedGoods = new ArrayList<>();

    public void addGoods(Goods goods) {
        addedGoods.add(goods);
    }


    public void addGoods(ArrayList<Goods> goods) {
        addedGoods.addAll(goods);
    }

    public ArrayList<Goods> getAll() {
        return new ArrayList<>(addedGoods);
    }

    public void clear() {
        addedGoods.clear();
    }

    @Override
    public String toString() {
        int counter=1;
        String Managing = "";
        for (Goods goods : addedGoods) {
            Managing += counter + "."+ goods+"\n";
            counter++;
        }
        return Managing;
    }
}
