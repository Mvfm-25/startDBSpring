// Serviço de Nice's para seprar a lógica de negócio.
// [mvfm]
//
// Criado : 12/11/2025  || Última vez alterado : 12/11/2025

package com.gdm.startdb;
import org.springframework.stereotype.Service;
import java.util.*;

@Service
public class NiceService {
    private Set<Membros> nicers = new HashSet<>();
    
    public NiceService() {
        nicers.add(new Membros("Mvfm", "Nicest"));
        nicers.add(new Membros("Kappe", "Nicer"));
        nicers.add(new Membros("Sheedoky", "Nicer"));
    }
    
    public Set<Membros> getAllNicers(){
        return nicers;
    }
    
    public void addNicers(List<Membros> novosNicers){
        nicers.addAll(novosNicers);
    }
}
