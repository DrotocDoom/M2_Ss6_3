import java.util.Scanner;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        int choice;
        int count = 0;
        String[] plateArray = new String[1000];
        String plateRegex = "^(1[1-9]|[2-9][0-9])[A-Z]{1,2}\\-\\d{3}\\.\\d{2}$";
        do {
            System.out.println("\n************* QUẢN LÝ BIỂN SỐ XE *************");
            System.out.println("1. Thêm các biển số xe");
            System.out.println("2. Hiển thị danh sách biển số xe");
            System.out.println("3. Tìm kiếm biển số xe");
            System.out.println("4. Tìm biển số xe theo mã tỉnh");
            System.out.println("5. Sắp xếp biển số xe tăng dần");
            System.out.println("6. Thoát");

            System.out.print("Lựa chọn của bạn: ");
            while (true){
                if (!input.hasNextInt()){
                    System.out.println("Vui lòng nhập số nguyên từ 1 đến 6!");
                    input.next();
                    continue;
                }
                choice = input.nextInt();
                input.nextLine();
                if (choice < 1 || choice > 6){
                    System.out.println("Vui lòng nhập số nguyên từ 1 đến 6!");
                    continue;
                }
                break;
            }
            switch (choice) {
                case 1 ->{
                    System.out.println("Nhập các biển số xe (nhập 'exit' để dừng):");
                    boolean stop = false;
                    for (int i = 0; i < plateArray.length && !stop; i++){
                        while (true){
                            System.out.print("Biển số xe thứ " + (i + 1) + ": ");
                            String plate = input.nextLine().toUpperCase();
                            if (plate.equalsIgnoreCase("EXIT")){
                                stop = true;
                                break;
                            }
                            if (!plate.matches(plateRegex)){
                                System.out.println("Biển số xe không hợp lệ. Vui lòng nhập lại.");
                                continue;
                            }
                            plateArray[count++] = plate;
                            break;
                        }
                    }
                }
                case 2 ->{
                    System.out.println("\nDanh sách biển số xe:");
                    for (int i = 0; i < count; i++){
                        System.out.println((i + 1) + ". " + plateArray[i]);
                    }
                }
                case 3 ->{
                    System.out.println("\nNhập biển số xe cần tìm kiếm:");
                    String searchPlate = input.nextLine().toUpperCase();
                    boolean found = false;
                    for (int i = 0; i < count && !found; i++){
                        if(plateArray[i] != null && plateArray[i].equals(searchPlate)){
                            System.out.println("Biển số xe " + searchPlate + " được tìm thấy tại vị trí " + (i + 1));
                            found = true;
                        }
                    }
                    if (!found){
                        System.out.println("Biển số xe " + searchPlate + " không được tìm thấy.");
                    }
                }
                case 4 ->{
                    System.out.println("\nNhập mã tỉnh cần tìm kiếm:");
                    String searchPlate = input.nextLine().toUpperCase();
                    for (int i = 0; i < count; i++){
                        if(plateArray[i].substring(0,2).equals(searchPlate)){
                            System.out.println("Biển số xe " + plateArray[i] + " được tìm thấy tại vị trí " + (i + 1));
                        }
                    }
                }
                case 5 ->{
                    for (int i = 0; i < count - 1; i++){
                        int minIndex = i;
                        for (int j = i + 1; j < count; j++){
                            if (plateArray[j].compareTo(plateArray[minIndex]) <= 0){
                                minIndex = j;
                            }
                        }
                        String temp = plateArray[minIndex];
                        plateArray[minIndex] = plateArray[i];
                        plateArray[i] = temp;
                    }
                    System.out.println("\nDanh sách biển số xe sau khi sắp xếp:");
                    for (int i = 0; i < count; i++){
                        System.out.println((i + 1) + ". " + plateArray[i]);
                        }
                }
                case 6 ->{
                    System.out.println("Cảm ơn bạn đã sử dụng chương trình!");
                    return;
                }
                default -> {
                    System.out.println("Lựa chọn không hợp lệ. Vui lòng chọn lại.");
                }
            }

        }while(true);

    }
}