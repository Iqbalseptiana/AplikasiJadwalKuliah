package programJadwalKuliah;


import java.util.Scanner;

interface Menu {
    void masukkanData();
    void rubahData();
    void hapusData();
    void tampilData();
}

abstract class Matkul implements Menu {
    protected String nama;
    protected int sks;

    public Matkul(String nama, int sks) {
        this.nama = nama;
        this.sks = sks;
    }

    public void tampilData() {
        System.out.println("Nama Mata Kuliah: " + nama);
        System.out.println("Total SKS: " + sks);
    }
}

class Teori extends Matkul {
    protected String dosen;
    protected String ruangan;

    public Teori(String nama, int sks, String dosen, String ruangan) {
        super(nama, sks);
        this.dosen = dosen;
        this.ruangan = ruangan;
    }

    public void masukkanData() {
        Scanner sc = new Scanner(System.in);
        System.out.print("Masukkan Nama Mata Kuliah: ");
        nama = sc.nextLine();
        System.out.print("Masukkan Total SKS: ");
        sks = sc.nextInt();
        sc.nextLine();
        System.out.print("Masukkan Nama Dosen: ");
        dosen = sc.nextLine();
        System.out.print("Masukkan Nama Kelas: ");
        ruangan = sc.nextLine();
        System.out.println("Data berhasil ditambahkan.");
    }

    public void rubahData() {
        Scanner sc = new Scanner(System.in);
        System.out.print("Masukkan Nama Mata Kuliah yang akan dirubah: ");
        String namaMK = sc.nextLine();
        if (nama.equals(namaMK)) {
            System.out.print("Masukkan Nama Dosen Baru: ");
            dosen = sc.nextLine();
            System.out.print("Masukkan Nama Kelas Baru: ");
            ruangan = sc.nextLine();
            System.out.println("Data berhasil dirubah.");
        } else {
            System.out.println("Data tidak ditemukan.");
        }
    }


    public void hapusData() {
        Scanner sc = new Scanner(System.in);
        System.out.print("Masukkan Nama Mata Kuliah yang akan dihapus: ");
        String namaMK = sc.nextLine();
        if (nama.equals(namaMK)) {
            nama = "";
            sks = 0;
            dosen = "";
            ruangan = "";
            System.out.println("Data berhasil dihapus.");
        } else {
            System.out.println("Data tidak ditemukan.");
        }
    }

    public void tampilData() {
        System.out.println("Data Mata Kuliah Teori:");
        super.tampilData();
        System.out.println("Nama Dosen: " + dosen);
        System.out.println("Nama kelas: " + ruangan);
    }
}

class Praktikum extends Matkul {
    protected int lab;

    public Praktikum(String nama, int sks, int lab) {
        super(nama, sks);
        this.lab = lab;
    }

    public void masukkanData() {
        Scanner sc = new Scanner(System.in);
        System.out.print("Masukkan Nama Mata Kuliah: ");
        nama = sc.nextLine();
        System.out.print("Masukkan Jumlah SKS: ");
        sks = sc.nextInt();
        sc.nextLine();
        System.out.print("Masukkan Ruang Laboratorium: ");
        lab = sc.nextInt();
        System.out.println("Data berhasil ditambahkan.");
    }

    public void rubahData() {
        Scanner sc = new Scanner(System.in);
        System.out.print("Masukkan Nama Mata Kuliah yang akan dirubah: ");
        String namaMK = sc.nextLine();
        if (nama.equals(namaMK)) {
            System.out.print("Masukkan Ruang Laboratorium Baru: ");
            lab = sc.nextInt();
            System.out.println("Data berhasil diubah.");
        } else {
            System.out.println("Data tidak ditemukan.");
        }
    }


    public void hapusData() {
        Scanner sc = new Scanner(System.in);
        System.out.print("Masukkan Nama Mata Kuliah yang akan dihapus: ");
        String namaMK = sc.nextLine();
        if (nama.equals(namaMK)) {
            nama = "";
            sks = 0;
            lab = 0;
            System.out.println("Data berhasil dihapus.");
        } else {
            System.out.println("Data tidak ditemukan.");
        }
    }

    public void tampilData() {
        System.out.println("Data Mata Kuliah Praktikum:");
        super.tampilData();
        System.out.println("Ruang Laboratorium: " + lab);
    }
}

public class Main {
    public static void main(String[] args) {
        System.out.println("**************************");
        System.out.println("####  Iqbal Septiana ####");
        System.out.println("##### 211011401527 #####");
        System.out.println("####### 04TPLE001 #######");
        System.out.println("**************************");

        Scanner sc = new Scanner(System.in);
        Matkul[] jadwal = new Matkul[10];
        int count = 0;
        int pilih;
        do {
            System.out.println("\n****** JADWAL MATA KULIAH ******");
            System.out.println("1. Tambah Data");
            System.out.println("2. Edit atau Hapus Data");
            System.out.println("3. Tampilakan Data");
            System.out.println("4. Keluar");
            System.out.println("**********************************");
            System.out.print("Input Pilihan: ");
            pilih = sc.nextInt();

            switch (pilih) {
                case 1:
                    System.out.println("\n****** TAMBAH DATA ******");
                    System.out.println("1. Mata Kuliah Teori");
                    System.out.println("2. Mata Kuliah Praktikum");
                    System.out.print("Input Pilihan: ");
                    int pilihMK = sc.nextInt();
                    sc.nextLine();

                    if (pilihMK == 1) {
                        jadwal[count] = new Teori("", 0, "", "");
                        jadwal[count].masukkanData();
                        count++;
                    } else if (pilihMK == 2) {
                        jadwal[count] = new Praktikum("", 0, 0);
                        jadwal[count].masukkanData();
                        count++;
                    } else {
                        System.out.println("Pilihan tidak valid.");
                    }
                    break;

                case 2:
                    System.out.println("\n****** RUBAH ATAU HAPUS DATA ******");
                    System.out.println("1. Rubah Data");
                    System.out.println("2. Hapus Data");
                    System.out.print("Input Pilihan: ");
                    int pilihEdit = sc.nextInt();
                    sc.nextLine();
                    System.out.print("Input Matkul Yang akan dirubah/hapus: ");
                    String namaMK = sc.nextLine();
                    boolean found = false;

                    for (int i = 0; i < count; i++) {
                        if (jadwal[i].nama.equals(namaMK)) {
                            found = true;
                            if (pilihEdit == 1) {
                                jadwal[i].rubahData();
                            } else if (pilihEdit == 2) {
                                jadwal[i].hapusData();
                                for (int j = i; j < count - 1; j++) {
                                    jadwal[j] = jadwal[j + 1];
                                }
                                jadwal[count - 1] = null;
                                count--;
                            }
                            break;
                        }
                    }
                    if (!found) {
                        System.out.println("Data tidak ditemukan.");
                    }
                    break;

                case 3:
                    System.out.println("\n****** MENAMPILKAN DATA ******");
                    for (int i = 0; i < count; i++) {
                        jadwal[i].tampilData();
                        System.out.println();
                    }
                    break;

                case 4:
                    System.out.println("Program selesai.");
                    break;

                default:
                    System.out.println("Pilihan tidak valid.");
                    break;
            }

        } while (pilih != 4);
    }

}