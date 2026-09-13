import javax.swing.*;
class Table
{
    public static void main(String[] args)
    {
        JFrame obj=new JFrame();
        obj.setSize(600,600);
        obj.setLayout(null);


        String arr[][]={{"Pratham jain","2427030705","Agra"},{"Harshit Arya","2427030668","Churu"},{"Harsh Gupta ","2427030680","Gururam"}};
        String col[]={"Name","Registration No.","City"};
        JTable t=new JTable(arr,col);

        JScrollPane sp=new JScrollPane(t);
        sp.setBounds(100,150,200,50);
        obj.add(sp);
        obj.setVisible(true);
    }
}