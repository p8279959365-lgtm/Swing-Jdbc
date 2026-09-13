


import java.util.*;
class hi
{
    public static void main(String[] args)
    {
        Scanner sc=new Scanner(System.in);
        int arr[][]=new int[3][3];
        int i,j;
        System.out.println("Enter the number ofelements in array");

        for(i=0;i<3;i++)
        {
            for(j=0;j<3;j++)
            {
                arr[i][j]=sc.nextInt();

            }
        }

        
        for(i=0;i<3;i++)
        {
            for(j=0;j<3;j++)
            {
                System.out.print(arr[i][j]+" ");
            }
            System.out.println();
        }


    }
}