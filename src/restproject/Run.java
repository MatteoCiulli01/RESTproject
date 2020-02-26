/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package restproject;

import java.util.Scanner;

/**
 *
 * @author informatica
 */
public class Run {
    public static void main(String[] args) {
        RESTproject r=new RESTproject();
        int select;
        do
        {
        System.out.println("Select an option");
        Scanner myObj1 = new Scanner(System.in);
        select = myObj1.nextInt();
        switch(select)
        {
            case 0:
                    return;
            case 1:
                r.get();
                    break;
            case 2:
                String[] dates = new String[5];
                for(int i = 0; i<5; i++)
                {
                    Scanner myObjP = new Scanner(System.in);
                    dates[i]= myObjP.nextLine(); 
                }
                r.post(dates);
                    break;
            case 3:
                System.out.println("Insert id for delete");
                Scanner myObjD = new Scanner(System.in);
                String idD = myObjD.nextLine();
                r.delete(idD);
                    break;
            case 4:
                System.out.println("Insert id for get");
                Scanner myObjG = new Scanner(System.in);
                String idG = myObjG.nextLine();
                r.getId(idG);
                    break;
            case 5:
                r.postId();
                    break;
        }
        }while(select != 0);
    }
}
