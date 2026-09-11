import java.util.Scanner;

class Employee {
    String name, address, mail, mobile;
    int id;
    double bp, da, hra, pf, staffClub, gross, net;

    void getData() {
        Scanner sc = new Scanner(System.in);

        System.out.print("Enter Employee Name: ");
        name = sc.nextLine();

        System.out.print("Enter Employee ID: ");
        id = sc.nextInt();
        sc.nextLine();

        System.out.print("Enter Address: ");
        address = sc.nextLine();

        System.out.print("Enter Mail ID: ");
        mail = sc.nextLine();

        System.out.print("Enter Mobile No: ");
        mobile = sc.nextLine();

        System.out.print("Enter Basic Pay: ");
        bp = sc.nextDouble();
    }

    void calculate(double daPer, double hraPer, double pfPer, double staffPer) {
        da = bp * daPer / 100;
        hra = bp * hraPer / 100;
        pf = bp * pfPer / 100;
        staffClub = bp * staffPer / 100;
        gross = bp + da + hra;
        net = gross - pf - staffClub;
    }

    void display() {
        System.out.println("\n******** PAY SLIP ********");
        System.out.println("Employee Name : " + name);
        System.out.println("Employee ID : " + id);
        System.out.println("Address : " + address);
        System.out.println("Mail ID : " + mail);
        System.out.println("Mobile No : " + mobile);
        System.out.println("Basic Pay : " + bp);
        System.out.println("DA : " + da);
        System.out.println("HRA : " + hra);
        System.out.println("PF : " + pf);
        System.out.println("Staff Club : " + staffClub);
        System.out.println("Gross Salary : " + gross);
        System.out.println("Net Salary : " + net);
    }
     public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("===== Employee Salary Calculation =====");
        System.out.println("1. Programmer");
        System.out.println("2. Assistant Professor");
        System.out.println("3. Associate Professor");
        System.out.println("4. Professor");
        System.out.print("Enter your choice: ");
        int ch = sc.nextInt();
        switch (ch) {
            case 1:
                Programmer p = new Programmer();
                p.getData();
                p.salary();
                p.display();
                break;
            case 2:
                AssistantProfessor ap = new AssistantProfessor();
                ap.getData();
                ap.salary();
                ap.display();
                break;
            case 3:
                AssociateProfessor asp = new AssociateProfessor();
                asp.getData();
                asp.salary();
                asp.display();
                break;
            case 4:
                Professor pr = new Professor();
                pr.getData();
                pr.salary();
                pr.display();
                break;
            default:
                System.out.println("Invalid Choice");
        }
    }
}
class Programmer extends Employee {
    void salary() {
        calculate(97, 10, 12, 1);
    }
}
class AssistantProfessor extends Employee {
    void salary() {
        calculate(110, 20, 12, 5);
    }
}
class AssociateProfessor extends Employee {
    void salary() {
        calculate(130, 30, 12, 10);
    }
}
class Professor extends Employee {
    void salary() {
        calculate(140, 40, 12, 15);
    }
}