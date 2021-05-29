package service;

import entity.Mahasiswa;
import java.rmi.Remote;
import java.rmi.RemoteException;
import java.util.List;


//class utk remote objek 
//menghubungkan permintaan client ke server 
public interface MhsInterface extends Remote {
    Mahasiswa insertMahasiswa (Mahasiswa mahasiswa) throws RemoteException;
    Mahasiswa updateMahasiswa (Mahasiswa mahasiswa) throws RemoteException;
    Mahasiswa deleteMahasiswa (Mahasiswa mahasiswa) throws RemoteException;
    Mahasiswa getMahasiswa (String nim) throws RemoteException;
    
    List<Mahasiswa> getAllMahasiswa() throws RemoteException; 
    
}
