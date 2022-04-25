package com.wbw.pattern.relational.iterator;

import java.util.ArrayList;

/**
 * @author wbw
 * @description: TODO
 * @date 2022-4-24 23:31
 */
public class CakeHouseMenu {
    private final ArrayList<MenuItem> menuItems;


    public CakeHouseMenu() {
        menuItems = new ArrayList<MenuItem>();

        addItem("KFC Cake Breakfast","boiled eggs&toast&cabbage",true,3.99f);
        addItem("MDL Cake Breakfast","fried eggs&toast",false,3.59f);
        addItem("Stawberry Cake","fresh stawberry",true,3.29f);
        addItem("Regular Cake Breakfast","toast&sausage",true,2.59f);
    }

    private void addItem(String name, String description, boolean vegetable,
                         float price) {
        MenuItem menuItem = new MenuItem(name, description, vegetable, price);
        menuItems.add(menuItem);
    }



    public Iterator getIterator()
    {
        return new CakeHouseIterator() ;
    }

    class CakeHouseIterator implements  Iterator
    {
        private int position=0;
        public CakeHouseIterator()
        {
            position=0;
        }

        @Override
        public boolean hasNext() {
            // TODO Auto-generated method stub
            return position < menuItems.size();
        }

        @Override
        public Object next() {
            // TODO Auto-generated method stub
            MenuItem menuItem =menuItems.get(position);
            position++;
            return menuItem;
        }}

}
