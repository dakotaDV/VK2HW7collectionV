import java.util.HashMap;
import java.util.Map;
import java.util.Objects;

public class EmployeeBook {
    private final Map<String, Employee> employees;

    public EmployeeBook() {
        this.employees = new HashMap<>();
    }

    private String getKey(Employee employee) {
        return employee.getName() + " " + employee.getLastName() + " " + employee.getMiddleName();
    }

    public void addEmployee(Employee employee) {
        employees.put(getKey(employee), employee);
    }

    public void addEmployee(String name,
                            String middleName,
                            String lastName,
                            int salary,
                            int department) {
        addEmployee(new Employee(name, middleName, lastName,  salary, department));
    }

    public void removeEmployee(Employee employee) {
        employees.remove(getKey(employee));
    }

    public void removeEmployee(int id) {
        for (Map.Entry<String, Employee> entry : employees.entrySet()) {
            String key = entry.getKey();
            Employee employee = entry.getValue();
            if (employee.getId() == id) {
                employees.remove(key);
                break;
            }
        }
    }

    public void changeSalary(Employee employee, double newSalary) {
        String key = getKey(employee);
        if (employees.containsKey(key)) {
            employees.get(key).setSalary(newSalary);
        }
    }

    public void changeDepartment(Employee employee, int newDepartment) {
        String key = getKey(employee);
        if (employees.containsKey(key)) {
            employees.get(key).setSalary(newDepartment);
        }
    }

    public void printEmployeesByDepartement() {
        for (int departament = 1; departament <= 5; departament++) {
            System.out.println("Сотрудники из отдела " + departament + ": ");
            for (Employee employee : employees.values()) {
                if (Objects.nonNull(employee)) { //&& employee.getDepartment() == departament){
                    System.out.println(employee.getLastName() + " " + employee.getName() + " " + employee.getMiddleName());
                }
            }
        }
    }

    public double averageSalary() {
        int count = 0;
        for (Employee employee : employees.values()) {
            if (Objects.nonNull(employee)) {
                count++;
            }
        }
        if (count != 0) {
            return totalSalaries() / count;
        }
        return 0;
    }

   // public double averagetSalaryForDepartament(int departament) {
       // double totalSalaryForDepartament = 0;
       // int count = 0;
       // for (Employee employee : employees.values()) {

          //  if (Objects.nonNull(employee) && employee.getDepartment() == dapartament) {
          //      totalSalaryForDepartament += employee.getSalary();

    //count++;
           // }
      //  }
    //    return count == 0 ? 0 : totalSalaryForDepartament / count;
  //  }

    public Employee findEmployeeWithMinSalaryFromDeparament(int departament) {
        double minSalary = Double.MAX_VALUE;
        String key = null;
        for (Map.Entry<String, Employee> entry : employees.entrySet()) {
            Employee employee = entry.getValue();
            if (Objects.nonNull(employee) && employee.getDepartment() == departament && employee.getSalary() < minSalary) {
                minSalary = employee.getSalary();
                key = entry.getKey();
            }
        }
        return key != null ? employees.get(key) : null;
    }

    public Employee findEmployeeWithMinSalary() {
        double minSalary = Double.MAX_VALUE;
        String key = null;
        for (Map.Entry<String, Employee> entry : employees.entrySet()) {
            Employee employee = entry.getValue();
            if (Objects.nonNull(employee) && employee.getDepartment() < minSalary) {
                minSalary = employee.getSalary();
                key = entry.getKey();
            }
        }
        return key != null ? employees.get(key) : null;
    }
    public Employee findEmployeeWithMaxSalaryFromDeparament(int departament) {
        double maxSalary = Double.MIN_VALUE;
        String key = null;
        for (Map.Entry<String, Employee> entry : employees.entrySet()) {
            Employee employee = entry.getValue();
            if (Objects.nonNull(employee) && employee.getDepartment() == departament && employee.getSalary() < maxSalary) {
                maxSalary = employee.getSalary();
                key = entry.getKey();
            }
        }
        return key != null ? employees.get(key) : null;
    }
    public Employee findEmployeeWithMaxSalary() {
        double maxSalary = Double.MIN_VALUE;
        String key = null;
        for (Map.Entry<String, Employee> entry : employees.entrySet()) {
            Employee employee = entry.getValue();
            if (Objects.nonNull(employee) && employee.getDepartment()  < maxSalary) {
                maxSalary = employee.getSalary();
                key = entry.getKey();
            }
        }
        return key != null ? employees.get(key) : null;
    }


    public double totalSalariesForDepartament(int departament) {
        double sum = 0;
        for (Employee employee : employees.values()) {
            if (Objects.nonNull(employee) && employee.getDepartment() == departament) {
                sum += employee.getSalary();
            }
        }
        return sum;
    }

    public double totalSalaries() {
        double sum = 0;
        for (Employee employee : employees.values()) {
            if (Objects.nonNull(employee)) {
                sum += employee.getSalary();
            }
        }
        return sum;

    }
    public void printFullNameEmployees(){
        for(Employee employee : employees.values()){
            if(Objects.nonNull(employee)){
                System.out.println(employee.getLastName() + "" + employee.getName() + "" + employee.getMiddleName());
            }
        }
    }

    public void printAllEmployees(){
        for (Employee employee : employees.values()){
            if(Objects.nonNull(employee)){
                System.out.println(employee);
            }
        }
    }
    public void printAllEmployeesFromDepartament(int departament){
        for (Employee employee : employees.values()){
            if(Objects.nonNull(employee) && employee.getDepartment() == departament){
                System.out.println(
                        "id: %d, ФИО: %S %S %S, ЗП: %.2f%n"
                );

            }
        }
    }

}