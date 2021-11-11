public class HeartTransplant {


    private Person[] listOfPatients;
    
    
    private SurvivabilityByAge[] survivabilityByAge;
    
    
    private SurvivabilityByCause[] survivabilityByCause;
    
    
    public HeartTransplant() {
    
    listOfPatients = null;
    survivabilityByAge = null;
    survivabilityByCause = null;
    }
    
    
    public int addPerson(Person p, int arrayIndex) {
    
    if(arrayIndex >= (listOfPatients.length-1)) 
    
    for(int i=(listOfPatients.length-1);i>arrayIndex;i--)
    {
    listOfPatients[i]=listOfPatients[i-1];
    }
    listOfPatients[arrayIndex]=p;
    
    return 0;
    }
    
    
    public int readPersonsFromFile(int numberOfLines) {
    
    int i;
    listOfPatients = new Person[numberOfLines];
    for(i=0;i<numberOfLines && StdIn.hasNextLine();i++)
    {
    int id,ethnicity,gender,age,cause,urgency,stateOfHealth;
    id = StdIn.readInt();
    ethnicity = StdIn.readInt();
    gender = StdIn.readInt();
    age = StdIn.readInt();
    cause = StdIn.readInt();
    urgency = StdIn.readInt();
    stateOfHealth = StdIn.readInt();
    listOfPatients[i] = new Person(id,ethnicity,gender,age,cause,urgency,stateOfHealth);
    }
    return (i);
    }
    
    
    public int readSurvivabilityRateByAgeFromFile (int numberOfLines) {
    
    int i;
    survivabilityByAge = new SurvivabilityByAge[numberOfLines];
    for(i=0;i<numberOfLines && StdIn.hasNextLine();i++)
    {
    int age,years;
    double rate;
    age = StdIn.readInt();
    years = StdIn.readInt();
    rate = StdIn.readDouble();
    survivabilityByAge[i] = new SurvivabilityByAge(age,years,rate);
    }
    return (i);
    }
    
    
    public int readSurvivabilityRateByCauseFromFile (int numberOfLines) {
    
    int i;
    survivabilityByCause = new SurvivabilityByCause[numberOfLines];
    for(i=0;i<numberOfLines && StdIn.hasNextLine();i++)
    {
    int cause,years;
    double rate;
    cause = StdIn.readInt();
    years = StdIn.readInt();
    rate = StdIn.readDouble();
    survivabilityByCause[i] = new SurvivabilityByCause(cause,years,rate);
    }
    return (i);
    }
    
    
    public Person[] getListOfPatients() {
    return listOfPatients;
    }
    
    
    public SurvivabilityByAge[] getSurvivabilityByAge() {
    return survivabilityByAge;
    }
    
    
    public SurvivabilityByCause[] getSurvivabilityByCause() {
    return survivabilityByCause;
    }
    
    
    public Person[] getPatientsWithAgeAbove(int age) {
    
    int count = 0;
    for(int i=0;i<listOfPatients.length;i++)
    {
    if(listOfPatients[i].getAge()>age)
    {
    count++;
    }
    }
    Person[] people = new Person[count];
    for(int i=0,j=0;i<listOfPatients.length && j<count;i++)
    {
    if(listOfPatients[i].getAge()>age)
    {
    people[j] = listOfPatients[i];
    j++;
    }
    }
    return people;
    }
    
    
    public Person[] getPatientsByStateOfHealth(int state) {
    
    int count = 0;
    for(int i=0;i<listOfPatients.length;i++)
    {
    if(listOfPatients[i].getStateOfHealth()==state)
    {
    count++;
    }
    }
    Person[] people = new Person[count];
    for(int i=0,j=0;i<listOfPatients.length && j<count;i++)
    {
    if(listOfPatients[i].getStateOfHealth()==state)
    {
    people[j] = listOfPatients[i];
    j++;
    }
    }
    return people;
    }
    
    
    public Person[] getPatientsByHeartConditionCause(int cause) {
    
    int count = 0;
    for(int i=0;i<listOfPatients.length;i++)
    {
    if(listOfPatients[i].getCause()==cause)
    {
    count++;
    }
    }
    Person[] people = new Person[count];
    for(int i=0,j=0;i<listOfPatients.length && j<count;i++)
    {
    if(listOfPatients[i].getCause()==cause)
    {
    people[j] = listOfPatients[i];
    j++;
    }
    }
    return people;
    }
    
    
    public Person[] match(int numberOfHearts) {
    
    if(numberOfHearts<listOfPatients.length)
    {
    Person[] people = new Person[numberOfHearts];
    for(int i=0;i<numberOfHearts;i++)
    {
    people[i] = listOfPatients[i];
    }
    return people;
    }
    else
    {
    return listOfPatients;
    }
    }
    
    
    public static void main (String[] args) {
    
    HeartTransplant ht = new HeartTransplant();
    
    
    int numberOfLines = StdIn.readInt();
    int numberOfReadings = ht.readPersonsFromFile(numberOfLines);
    StdOut.println(numberOfReadings + " patients read from file.");
    
    
    numberOfLines = StdIn.readInt();
    numberOfReadings = ht.readSurvivabilityRateByAgeFromFile(numberOfLines);
    StdOut.println(numberOfReadings + " survivability rates by age lines read from file.");
    
    
    numberOfLines = StdIn.readInt();
    numberOfReadings = ht.readSurvivabilityRateByCauseFromFile(numberOfLines);
    StdOut.println(numberOfReadings + " survivability rates by cause lines read from file.");
    
    
    for (Person p : ht.getListOfPatients()) {
    StdOut.println(p);
    }
    
    for (SurvivabilityByAge rate : ht.getSurvivabilityByAge()) {
    StdOut.println(rate);
    }
    
    
    for (SurvivabilityByCause rate : ht.getSurvivabilityByCause()) {
    StdOut.println(rate);
    }
    
    }
    }