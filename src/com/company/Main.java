package com.company;
//import javax.swing.JFrame;
//import javax.swing.JComponent;

public class Main {

    public static void main(String[] args) {
        double[] userData = userInput();
        double a = userData[0], b = userData[1], c = userData[2], distanceBetweenPoints = userData[4];
        int amountOfPoints = (int) userData[3];

        double[][] cords = addCords(a, b, c, amountOfPoints, distanceBetweenPoints);
        //            for(int i = 0; i <= 1; i++ ){
        //                System.out.println(minimumF[i]);
        //            }


//        System.out.println(MIN);
//       JFrame frame = new JFrame();
//        frame.setSize(800, 600);
//        frame.setTitle("Graphs");
//        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
//        frame.setLocationRelativeTo(null);
//        frame.setVisible(true);
    }

    public static double[] userInput(){ // лучше статический массив
        double a = -2, b = 3, c = -1;
        int amountOfPoints = 20;
        double distanceBetweenPoints = 0.5; // 0 < distanceBetweenPoints =< 1

        double[] userData = new double[5];
        userData[0] = a;
        userData[1] = b;
        userData[2] = c;
        userData[3] = amountOfPoints;
        userData[4] = distanceBetweenPoints;
        return userData;
    }

    public static double[][] addCords(double a, double b, double c, int amountOfPoints, double distanceBetweenPoints){
        double[][] cords = new double[2][amountOfPoints+1];
        double[] minimum = new double[2];
        if ((b * b) - (4 * a * c)> 0) {
            double[] cord0X = cord0X(a, b, c);
            minimum = minimumParabola(a, b, c);
            cords = morePoints(a, b, c, amountOfPoints-3, distanceBetweenPoints, minimum);
        }else{
            minimum[0]=0;minimum[1]=c;
            if (a != 0 && b != 0){
                if (a != 0){
                    minimum = minimumParabola(a, b, c);
                }if (a == 0 && b != 0){
                    minimum = minimumLine(b, c);
                }
                cords = morePoints(a, b, c, amountOfPoints-1, distanceBetweenPoints, minimum);
            }
            cords = morePoints(a, b, c, amountOfPoints, distanceBetweenPoints, minimum);
        }
        return cords;
    }

    public static double[] cord0X(double a, double b, double c) {
        double discriminant = Math.sqrt((b * b) - (4 * a * c));
        double x1 = -b + discriminant / 2 * a;
        double x2 = -b - discriminant / 2 * a;
        double[] cords = {x1, x2};
        return cords;
    }

    public static double[] minimumLine(double b, double c){
        double cords[] = new double[2];
        cords[0] = -c / b;
        cords[1] = 0;
        return cords;
    }

    public static double[] minimumParabola(double a, double b, double c) {
        double cords[] = new double[2];
        cords[0] = -b / 2 * a;
        cords[1] = a * ( cords[0] *  cords[0]) + b *  cords[0] + c;
        return cords;
    }

    public static double[][] morePoints(double a, double b, double c, int amountOfPoints, double distanceBetweenPoints, double[] minimum){
        double[][] cords = new double[2][amountOfPoints+1]; //= {{x1,y1}, {x2,y2}};
        for (int j = 0; j <= amountOfPoints; j++) {
            for (int i = 0; i <= 1; i++) {
                double x = ;
                double y = a*(x*x)+b*x+c;
                if(i == 0){
                    cords[0][j] = x;
                }else {
                    cords[1][j] =y;
                }
            }
        }
        return cords;
    }
}
