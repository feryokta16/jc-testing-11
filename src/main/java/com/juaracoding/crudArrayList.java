package com.juaracoding;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;

public class crudArrayList {
    //declaasi variable yang diperlukan
    static String fileName;
    static ArrayList<String> productLists;
    static boolean isEditing = false;
    static Scanner input;

    public static void main(String[] args) {
        //inisiasi
        productLists = new ArrayList<>();
        input = new Scanner(System.in);
        //menentukan lokaso penyimpanan file
        String filePath = System.console() == null ? "/src/productlist.txt": "/productlist.txt";
        fileName = System.getProperty("user.dir") + filePath;

        System.out.println("File : " + fileName);
        //menjalankan program
        while(true){
            showMenu();
        }
    }

    static void clearScreen(){
        try{
            // untuk melakukan clear screen
            final String os = System.getProperty("os.name");
            if(os.contains("windows")) {
                Runtime.getRuntime().exec("cls");
            }
        }
        catch (final Exception e){
            e.printStackTrace();
        }
    }

    // membuat fuction show menu
    static  void showMenu(){
        System.out.println("Program Sederhana Nama Product");
        System.out.println("[1] Lihat Product");
        System.out.println("[2] Tambah Product");
        System.out.println("[3] Edit Product");
        System.out.println("[4] Hapus Peoduct");
        System.out.println("[0] Keluar");
        System.out.println("-------------------");
        System.out.print("Pilih menu > ");

        //menentukan fuction mana yang akan di eksekusi
        String selectedMenu = input.nextLine();
        if(selectedMenu.equals("1")){
            showProductList();
        }else if(selectedMenu.equals("2")){
            addProductList();
        }else if(selectedMenu.equals("3")){
            editProductList();
        }else if(selectedMenu.equals("4")){
            deleteProductList();
        }else if(selectedMenu.equals("0")){
            System.exit(0);
        }else{
            System.out.println("Angka yang dinput tidak ada");
            backToMenu();
        }
    }
    //membuat function back to menu utama
    static void backToMenu(){
        System.out.println("");
        System.out.print("Tekan [Enter] untuk kembali");
        input.nextLine();
        clearScreen();
    }
    //membuat function read
    static void readProductList(){
        try{
            File file = new File(fileName);
            Scanner fileReader = new Scanner(file);
            //load isi file ke dalam array
            productLists.clear();
            while(fileReader.hasNextLine()){
                String data = fileReader.nextLine();
                productLists.add(data);
            }
        }catch (FileNotFoundException e){
            System.out.println("terjadi kesalahan : " + e.getMessage());
        }
    }
    //membuat fuction untuk menampilkan data product
    static void showProductList(){
        clearScreen();
        readProductList();
        if(productLists.size()>0){
            System.out.println("Product List : ");
            int index = 0;
            for(String data : productLists){
                System.out.println(String.format("[%d] %s", index, data));
                index++;
            }
        }else {
            System.out.println("Tidak ada data Product");
        }
        if(!isEditing){
            backToMenu();
        }
    }
    //membuat function menambahkan function
    static void addProductList(){
        clearScreen();
        System.out.println("Tambahkan Product");
        System.out.print("Masukan Product :");
        String newTodoList = input.nextLine();
        try{
            //menulis file yang akan di tambahkan
            FileWriter fileWriter = new FileWriter(fileName,true);
            fileWriter.append(String.format("%s%n", newTodoList));
            fileWriter.close();
            System.out.println("Berhasil Menambhakan Product");
        }catch (IOException e){
            System.out.println("Terjadi kesalahan : " + e.getMessage());
        }
        backToMenu();
    }
    static void editProductList(){
        isEditing = true;
        showProductList();
        try{
            System.out.println("-----------");
            System.out.print("pilih index > ");
            int index = Integer.parseInt(input.nextLine());

            if(index>productLists.size()){
                throw new IndexOutOfBoundsException("data yang dimasukan salah");
            }else{
                System.out.print("data baru : ");
                //melakukan update data
                String newData = input.nextLine();
                productLists.set(index, newData);
                System.out.println(productLists.toString());

                try{
                    FileWriter fileWriter = new FileWriter(fileName, false);
                    //menuliskan file baru
                    for (String data : productLists){
                        fileWriter.append(String.format("%s%n", data));
                    }
                    fileWriter.close();
                }
                catch (IOException e){
                    System.out.println("terjadi kesalahan" + e.getMessage());
                }
            }

        }catch ( Exception e){
            System.out.println(e.getMessage());
        }
        isEditing = false;
        backToMenu();
    }
    static void deleteProductList(){
        isEditing = true;
        showProductList();
        System.out.println("---------");
        System.out.print("pilih index>");
        int index = Integer.parseInt(input.nextLine());

        try{
            if(index > productLists.size()){
                throw new IndexOutOfBoundsException("data yang dimasukan salah");

            }else{
                System.out.println("data yang akan dihapus");
                System.out.println(String.format("[%d] %s", index, productLists.get(index)));
                System.out.println("apakah sudah benar data yang akan dihapus");
                System.out.println("jawab (y/t) : ");
                String jawab = input.nextLine();
                //melakukan hapus data
                if(jawab.equalsIgnoreCase("y")){
                    productLists.remove(index);

                    try{
                        FileWriter fileWriter = new FileWriter(fileName, false);
                        //menuliskan data baru
                        for(String data : productLists){
                            fileWriter.append(String.format("%s%n", data));
                        }
                        fileWriter.close();
                    }catch (IOException e){
                        System.out.println("terjadi kesalahan : " + e.getMessage());
                    }
                }
            }
        }catch (Exception e){
            System.out.println(e.getMessage());
        }
        isEditing= false;
        backToMenu();
    }
}
