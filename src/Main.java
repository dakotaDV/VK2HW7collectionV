public class Main {
    public static void main(String[] args) {
        EmployeeBook employeeBook = new EmployeeBook();
        Employee sergey = new Employee("Сергей", "Викторович", "Королев", 1, 355000);


        employeeBook.addEmployee("Сергей", "Викторович", "Королев", 2, 355000 );
        employeeBook.addEmployee(sergey);

        employeeBook.changeSalary(sergey,1);

        employeeBook.printEmployeesByDepartement();
        employeeBook.printAllEmployees();
        double totalSalaries = employeeBook.totalSalaries();
        System.out.printf("Сумма ЗП всех сотрудников за месяц: %.3f%n" + totalSalaries);
        Employee employeeWithMinSalary = employeeBook.findEmployeeWithMinSalary();
        System.out.printf("Сотрудник с мин ЗП" + employeeWithMinSalary);
        Employee employeeWithMaxSalary = employeeBook.findEmployeeWithMaxSalary();
        System.out.printf("Сотрудник с максимальной ЗП:" + employeeWithMaxSalary);
       // double averageSalary = employeeBook.averageSalary();
       // System.out.println("Средняя ЗП всех сотрудиков за месяц: %,3f%n", averageSalary);
        employeeBook.printFullNameEmployees();

       // employeeBook.indexSalaries(10);
       // System.out.println("После индексации");
       // employeeBook.printAllEmployees();

        System.out.printf("Сотрудник с мин зп из %d отдела: %s%n", 1, employeeBook.findEmployeeWithMinSalaryFromDeparament(1));
        System.out.printf("Сотрудник с макс зп из %d отдела: %s%n", 1, employeeBook.findEmployeeWithMaxSalaryFromDeparament(2));
        System.out.printf("Сумма ЗП всех сотрудников за месяц из отдела %d: %.2f%n", 3, employeeBook.totalSalariesForDepartament(3));
        //System.out.println("Средняя ЗП всех сотрудников за месяц из отдела %d: %.3f%n", 4, employeeBook.averageSalaryForDeartament());

        //employeeBook.indexSalariesForDepartament(5, 1);
        // System.out.println("После индексации для отдела " +1);
        employeeBook.printAllEmployeesFromDepartament(1);








    }



}
