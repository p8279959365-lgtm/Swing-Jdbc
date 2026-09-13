

import javax.swing.*;
import javax.swing.tree.DefaultMutableTreeNode;
class TREE 
{
    public static void main(String[] args)
    {
        JFrame obj=new JFrame();
        obj.setSize(600,600);
        obj.setLayout(null);

        DefaultMutableTreeNode color=new DefaultMutableTreeNode("Color");
        DefaultMutableTreeNode slangs=new DefaultMutableTreeNode("Slangs");
        DefaultMutableTreeNode style=new DefaultMutableTreeNode("style");
        style.add(color);
        style.add(slangs);
        color.add(new DefaultMutableTreeNode("Red"));
        color.add(new DefaultMutableTreeNode("Blue "));
        color.add(new DefaultMutableTreeNode("yellow"));
        slangs.add(new DefaultMutableTreeNode("Hi"));
        slangs.add(new DefaultMutableTreeNode("hello "));
        JTree jt=new JTree(style);
        JScrollPane sp=new JScrollPane(jt);
        sp.setBounds(20,50,100,100);
        obj.add(sp);
        obj.setVisible(true);
        obj.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }
}