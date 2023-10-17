package MatchFixtureBuilder;
import java.util.Collections;
import java.util.*;

public class MatchFixture {
private ArrayList<String> teams=new ArrayList<>();
private int numberOfTeam;

Scanner sc=new Scanner(System.in);
Scanner scan=new Scanner(System.in);


    public int getNumberOfTeam() {
        return numberOfTeam;
    }

    public void setNumberOfTeam(int numberOfTeam) {
        this.numberOfTeam = numberOfTeam;
    }

    public ArrayList<String> getTeams() {
        return teams;
    }

    public void setTeams(ArrayList<String> teams) {
        this.teams = teams;
    }
    public void Teams(){
        int numberOfTeam=0;
        try {
            System.out.println("Kaç adet takım gireceksiniz ?");
             numberOfTeam = sc.nextInt();
        }catch (InputMismatchException e){

            System.out.println("Hatalı değer girdiniz lütfen tam sayı giriniz");
            System.out.println("Varsayılan takım sayısı 18 olarak ayarlandı..");
            numberOfTeam=18;
        }
        System.out.println("Takım adını giriniz?");
        String teamsName;
        for(int i=0; i<numberOfTeam; i++) {  //Kullanıcıdan takımların alınması

            System.out.println(i + 1 + ". Takımı girin");
             teamsName = scan.nextLine().toUpperCase();
             while(this.teams.contains(teamsName)){
                 System.out.println("Daha önce bu takımı girdiniz tekrar yeni bir takım girin.");
                 teamsName = scan.nextLine();

             }
             this.teams.add(teamsName);
        }
        int total=1;
        System.out.println("TAKIMLAR :"); //Takımların yazdırılması
        for (String s:this.teams) {
            System.out.println(total+"-"+s);
            total++;
        }


        int numberOfWeek=0;
        if(this.teams.size()%2==0) {   //Takım sayısına göre maç oynanacak hafta sayısının belirlenmesi
            numberOfWeek = (this.teams.size() - 1) * 2;
        }
        if(this.getTeams().size()%2!=0) {     //Takım sayısı tek ise her hafta bir takım BAY geçer.
             numberOfWeek = this.teams.size() * 2;
             this.teams.add("BAY");

        }

        Collections.shuffle(this.teams);       //Shuffle metodu ile eklenilen sıra karıştırıldı.
        System.out.println("Takımlar karıştırıldı");

            String s=this.teams.get(0);

            teams.remove(0);



            for(int j=0; j<numberOfWeek; j++ ) {
             System.out.println(j+1+". hafta maçları:");
                System.out.println("####################");
             if(j%2==0) {
                 System.out.println(s + " "+ "vs" +" "+ teams.get(0));
             }
             else{
                 System.out.println(this.teams.get(0) + " "+ "vs" +" "+ s);
             }
             for(int k=0; k<this.teams.size()/2; k++ ){

                 if(j%2==0) {
                     System.out.println( this.teams.get(this.teams.size() - k - 1)+" "+ "vs" +" "+this.teams.get(k + 1));
                 }
                 else {
                     System.out.println(this.teams.get(k + 1) + " " + "vs" + " " + this.teams.get(this.teams.size() - k - 1));
                 }
             }
                Collections.rotate(this.teams, 1);

            }

    }
}
