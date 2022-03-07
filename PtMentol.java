import java.util.Scanner;
import java.util.ArrayList;
import java.util.Random;
import java.util.Map;
import java.util.HashMap;
import java.util.Collections;

public class PtMentol{
   static ArrayList<person> Karyawan= new ArrayList<person>();
   static Scanner UserInput = new Scanner( System.in );
   public class person{
      public String Id;
      public String Name;
      public String JenisKelamin;
      public String Jabatan;
      public int Gaji;

      public person(String id ,String name,String JenisKelamin,String Jabatan,int Gaji){
      this.Id=id;
      this.Name=name;
      this.JenisKelamin=JenisKelamin;
      this.Jabatan=Jabatan;
      this.Gaji=Gaji;
      }
   }
   public PtMentol(){
      while(true){
         System.out.println("1. input data karyawan:");
         System.out.println("2. view data karyawan:");
         System.out.println("3. update data karyawan:");
         System.out.println("4. delete data karyawan:");
         System.out.printf("Masukan Input:");
         int choice = UserInput.nextInt();
         UserInput.nextLine();
         switch(choice){
            case 1:
               System.out.println("input data karyawan:");
               insert_data(0);
               break;
            case 2:
               System.out.println("view data karyawan:");
               view_data();
               break;
            case 3:
               System.out.println("update data karyawan:");
               update_data();
               break;
            case 4:
               System.out.println("delete data karyawan:");
               delete_data();
               break;
            default:
               continue;
         }
      }
   }

   //validasi belom
   private void insert_data(int change) {
      String kodeKaryawan,namaKaryawan,jenisKelamin,jabatan;
      int gaji;
      //initialise string to emptystring
      kodeKaryawan=namaKaryawan=jenisKelamin=jabatan="";

      // while(kodeKaryawan.substring(0,2).is)
      System.out.printf("Masukan Kode Karyawan: ");
      kodeKaryawan = UserInput.nextLine();

      while(namaKaryawan.length()<3){
         System.out.printf("Masukan Nama Karyawan: ");
         namaKaryawan = UserInput.nextLine();
      }
      while(!jenisKelamin.equals("Laki-Laki")&&!jenisKelamin.equals("Perempuan")){
         System.out.printf("Masukan Jenis Kelamin: ");
         jenisKelamin = UserInput.nextLine();
      }
      while(!jabatan.equals("Manager")&&!jabatan.equals("Supervisor")&&!jabatan.equals("Admin")){
         System.out.printf("Masukan Jabatan: ");
         jabatan = UserInput.nextLine();
      }
      gaji = (jabatan.equals("Manager"))?8000000:
         (jabatan.equals("Supervisor"))?6000000:4000000;


      person p = new person(kodeKaryawan,namaKaryawan,jenisKelamin,jabatan,gaji);

      //setiap ada data yang masuk lgsg kita sort
      ascending();
      if(change == 0)
         Karyawan.add(p);
      else
         change -=1;
         Karyawan.get(change).Id = kodeKaryawan;
         Karyawan.get(change).Name = namaKaryawan;
         Karyawan.get(change).JenisKelamin = jenisKelamin;
         Karyawan.get(change).Jabatan = jabatan;
         Karyawan.get(change).Gaji = gaji;
   }
   private void ascending(){
      if(Karyawan.isEmpty())return;
      for(int i = 0 ; i<Karyawan.size() ; i++){
         for(int j = 1 ; j<Karyawan.size() ; j++){
            if(Karyawan.get(i).Name.compareTo(Karyawan.get(j).Name)>1){
               //ketika yg awal lebih besar selanjutnya mau kita tuker
               Collections.swap(Karyawan,i,j);
            }
         }
      }
   }
   //besok tinggal clean up
   private void view_data() {
      System.out.printf("%s %-20s %-20s %-20s %-20s %-20s\n",
      "No",
      "Kode Karyawan",
      "Nama Karyawan",
      "Jenis Kelamin",
      "Jabatan",
      "Gaji"
      );
      for(int i = 0 ; i<Karyawan.size() ; i++){
         System.out.printf("%d %-20s %-20s %-20s %-20s %-20s\n",
         i+1,
         Karyawan.get(i).Id,
         Karyawan.get(i).Name,
         Karyawan.get(i).JenisKelamin,
         Karyawan.get(i).Jabatan,
         Karyawan.get(i).Gaji);
      }
   }
   private void update_data() {
      if(Karyawan.isEmpty()) System.out.println("No data to update");
      else{
         view_data();
         int number = UserInput.nextInt();
         UserInput.nextLine();
         insert_data(number);
      }
   }

   private void delete_data() {
      if(Karyawan.isEmpty()) System.out.println("No data to delete");
      else{
         view_data();
         int number = UserInput.nextInt();
         UserInput.nextLine();
         Karyawan.remove(number-1);
      }
   }
   public static void main(String[] args){
      new PtMentol();
   }




//end main
}

