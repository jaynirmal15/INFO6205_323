/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package TimeTableGA;

/**
 *
 * @author Jay
 */
public class TimeTableGA {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        Schedule schedule = initializeSchedule();
        
        // Initialize GA
        GeneticAlgorithm ga = new GeneticAlgorithm(100, 0.01, 0.9, 2, 5);
        
        // Initialize population
        Population population = ga.initPopulation(schedule);
        
        // Evaluate population
        ga.evalPopulation(population, schedule);
        
        // Keep track of current generationNumber
        int generationNumber = 1;
        
        // Start evolution loop
        while (ga.GenerationReachedToMaximumPoint(generationNumber, 1000) == false
            && ga.isTerminationConditionMet(population) == false) {
            // Print fitness
            System.out.println("G" + generationNumber + " Best fitness: " + population.getFittest(0).getFitness());

            // Apply crossover
            population = ga.crossoverPopulation(population);

            // Apply mutation
            population = ga.mutatePopulation(population, schedule);

            // Evaluate population
            ga.evalPopulation(population, schedule);

            // Increment the current generationNumber
            generationNumber++;
        }

        // Print fitness
        schedule.createNewClasses(population.getFittest(0));
        System.out.println();
        System.out.println("Solution found in " + generationNumber + " generations");
        System.out.println("Final solution fitness: " + population.getFittest(0).getFitness());
        System.out.println("Clashes: " + schedule.calculateClashes());

        // Print classes
        System.out.println();
        Class classes[] = schedule.getClasses();
        int classIndex = 1;
        for (Class bestClass : classes) {
            System.out.println("Class " + classIndex + ":");
            System.out.println("Module: " + 
                    schedule.getCourse(bestClass.getCourseID()).getCourseName());
            System.out.println("Group: " + 
                    schedule.getGroup(bestClass.getGroudID()).getGroupID());
            System.out.println("Room: " + 
                    schedule.getRoom(bestClass.getRoomID()).getRoomNumber());
            System.out.println("Professor: " + 
                    schedule.getProfessor(bestClass.getProfessorID()).getProfessorName());
            System.out.println("Time: " + 
                    schedule.getTimeslot(bestClass.getTimeSlotID()).getTimeSlot());
            System.out.println("-----");
            classIndex++;
        }
    }
    
	private static Schedule initializeSchedule() {
		// Create timetable
		Schedule sch = new Schedule();

		// Set up rooms
		sch.addRoom(1, "A1", 15);
		sch.addRoom(2, "B1", 30);
		sch.addRoom(4, "D1", 20);
		sch.addRoom(5, "F1", 25);

		// Set up timeslots
		sch.addTimeslot(1, "Mon 9:00 - 11:00");
		sch.addTimeslot(2, "Mon 11:00 - 13:00");
		sch.addTimeslot(3, "Mon 13:00 - 15:00");
		sch.addTimeslot(4, "Tue 9:00 - 11:00");
		sch.addTimeslot(5, "Tue 11:00 - 13:00");
		sch.addTimeslot(6, "Tue 13:00 - 15:00");
		sch.addTimeslot(7, "Wed 9:00 - 11:00");
		sch.addTimeslot(8, "Wed 11:00 - 13:00");
		sch.addTimeslot(9, "Wed 13:00 - 15:00");
		sch.addTimeslot(10, "Thu 9:00 - 11:00");
		sch.addTimeslot(11, "Thu 11:00 - 13:00");
		sch.addTimeslot(12, "Thu 13:00 - 15:00");
		sch.addTimeslot(13, "Fri 9:00 - 11:00");
		sch.addTimeslot(14, "Fri 11:00 - 13:00");
		sch.addTimeslot(15, "Fri 13:00 - 15:00");

		// Set up professors
		sch.addProfessor(1, "Dr P Smith");
		sch.addProfessor(2, "Mrs E Mitchell");
		sch.addProfessor(3, "Dr R Williams");
		sch.addProfessor(4, "Mr A Thompson");

		// Set up modules and define the professors that teach them
		sch.addCourse(1, "cs1", "Computer Science", new int[] { 1, 2 });
		sch.addCourse(2, "en1", "English", new int[] { 1, 3 });
		sch.addCourse(3, "ma1", "Maths", new int[] { 1, 2 });
		sch.addCourse(4, "ph1", "Physics", new int[] { 3, 4 });
		sch.addCourse(5, "hi1", "History", new int[] { 4 });
		sch.addCourse(6, "dr1", "Drama", new int[] { 1, 4 });

		// Set up student groups and the modules they take.
		sch.addGroup(1, 10, new int[] { 1, 3 });
		sch.addGroup(2, 30, new int[] { 2, 3 });
		sch.addGroup(3, 18, new int[] { 3 });
		sch.addGroup(4, 25, new int[] { 1 });
		sch.addGroup(5, 20, new int[] { 2, 3, 5 });
		sch.addGroup(6, 22, new int[] { 1, 4, 5 });
		sch.addGroup(7, 16, new int[] { 1, 3 });
		sch.addGroup(8, 18, new int[] { 2, 6 });
		sch.addGroup(9, 24, new int[] { 1, 6 });
		sch.addGroup(10, 25, new int[] { 3, 4 });
		return sch;
	}
    }
    

