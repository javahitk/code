INTERFACE:-
  interface Department {
    void getDepartmentData(String name, String head);
    void printDepartmentData();
}

class Hostel {
    String hostelName, hostelLocation;
    int noOfRooms;

    void getHostelData(String name, String location, int rooms) {
        hostelName = name;
        hostelLocation = location;
        noOfRooms = rooms;
    }

    void printHostelData() {
        System.out.println("Hostel Name: " + hostelName);
        System.out.println("Location: " + hostelLocation);
        System.out.println("Rooms: " + noOfRooms);
    }
}

class Student extends Hostel implements Department {
    String studentName, regNo, electiveSubject;
    double avgMarks;
    String depName, depHead;

    void getData(String name, String reg, String subject, double marks,
                 String hName, String hLoc, int rooms,
                 String dName, String dHead) {
        studentName = name;
        regNo = reg;
        electiveSubject = subject;
        avgMarks = marks;

        getHostelData(hName, hLoc, rooms);
        getDepartmentData(dName, dHead);
    }

    void printData() {
        System.out.println("Name: " + studentName);
        System.out.println("Reg No: " + regNo);
        System.out.println("Elective: " + electiveSubject);
        System.out.println("Avg Marks: " + avgMarks);
        printHostelData();
        printDepartmentData();
    }

    public void getDepartmentData(String name, String head) {
        depName = name;
        depHead = head;
    }

    public void printDepartmentData() {
        System.out.println("Department: " + depName);
        System.out.println("Head: " + depHead);
    }
}

public class main {
    public static void main(String[] args) {
        Student s = new Student();
        s.getData("Alice", "REG123", "AI & ML", 87.5,
                  "Sunrise Hostel", "North Campus", 120,
                  "CSE", "Dr. Smith");

        s.printData();
    }
}
------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------
ABSTRACT CODE:-
  abstract class ThreeDObject {
    protected double dim1, dim2, dim3;

    abstract double volume();
    abstract double wholesurfacearea();
}

// Box class: volume = l * w * h, surface area = 2(lw + lh + wh)
class Box extends ThreeDObject {
    Box(double l, double w, double h) {
        dim1 = l; dim2 = w; dim3 = h;
    }

    double volume() {
        return dim1 * dim2 * dim3;
    }

    double wholesurfacearea() {
        return 2 * (dim1 * dim2 + dim1 * dim3 + dim2 * dim3);
    }
}

// Cube class: volume = a³, surface area = 6a²
class Cube extends ThreeDObject {
    Cube(double a) {
        dim1 = a;
    }

    double volume() {
        return dim1 * dim1 * dim1;
    }

    double wholesurfacearea() {
        return 6 * dim1 * dim1;
    }
}

// Cylinder class: volume = πr²h, surface area = 2πr(h + r)
class Cylinder extends ThreeDObject {
    Cylinder(double r, double h) {
        dim1 = r; dim2 = h;
    }

    double volume() {
        return Math.PI * dim1 * dim1 * dim2;
    }

    double wholesurfacearea() {
        return 2 * Math.PI * dim1 * (dim1 + dim2);
    }
}

// Cone class: volume = (1/3)πr²h, surface area = πr(l + r), l = slant height
class Cone extends ThreeDObject {
    Cone(double r, double h) {
        dim1 = r; dim2 = h;
    }

    double volume() {
        return (1.0 / 3) * Math.PI * dim1 * dim1 * dim2;
    }

    double wholesurfacearea() {
        double l = Math.sqrt(dim1 * dim1 + dim2 * dim2); // slant height
        return Math.PI * dim1 * (dim1 + l);
    }
}

// Main class to test
public class abs {
    public static void main(String[] args) {
        ThreeDObject box = new Box(2, 3, 4);
        ThreeDObject cube = new Cube(3);
        ThreeDObject cylinder = new Cylinder(2, 5);
        ThreeDObject cone = new Cone(3, 4);

        System.out.println("Box Volume: " + box.volume());
        System.out.println("Box Surface Area: " + box.wholesurfacearea());

        System.out.println("\nCube Volume: " + cube.volume());
        System.out.println("Cube Surface Area: " + cube.wholesurfacearea());

        System.out.println("\nCylinder Volume: " + cylinder.volume());
        System.out.println("Cylinder Surface Area: " + cylinder.wholesurfacearea());

        System.out.println("\nCone Volume: " + cone.volume());
        System.out.println("Cone Surface Area: " + cone.wholesurfacearea());
    }
}
