package data;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;

import com.google.gson.Gson;

import models.usuarios.Admin;
import util.TipoDepartamento;

public class ObtenerAdmins {

    public static ArrayList<Admin> cargarDesdeArchivo() {
        ArrayList<Admin> entidades = new ArrayList<>();

        entidades.add(new Admin("Biblioteca", "8d6341258d8d4cb6a91899ca1f704721e59a634b1723f775e382b6e48069d753",
                TipoDepartamento.Biblioteca));
        entidades.add(new Admin("Economia", "ba9e01dd549bb3198c02d2527ae78fa9d68f2fa09914e22db021116288ff0056",
                TipoDepartamento.Economia));
        entidades.add(
                new Admin("SeguridadInformatica", "53f99543996ee802643faf371e3e20198a81529d2b2c0de66263b328c8b449b7",
                        TipoDepartamento.SeguridadInformatica));
        entidades.add(
                new Admin("AlmacenLibrosDocentes", "306be972ea5183361eee3898e087c281945e37b396d8647a50686206c80492cd",
                        TipoDepartamento.AlmacenLibrosDocentes));
        entidades.add(new Admin("DireccionBecas", "c2755cf310aa84fef987773aeb2a2356a55abf7cb7eb9af22ef0f3783ed35d37",
                TipoDepartamento.DireccionBecas));
        entidades.add(new Admin("Contabilidad", "38cd88c523e691aa53962a84b6df308b95046102b7e9d67f660be4b86b891d11",
                TipoDepartamento.Contabilidad));
        entidades.add(new Admin("Secretaria", "3e7100903faebe330d30fd23a5563830568bca178d5210986163528da8fac196",
                TipoDepartamento.Secretaria));
        entidades.add(new Admin("RecursosHumanos", "c0623a2bad27da1067a64748a9bc0ced2be41eaa7ea48fe9a2ff91f7b2b480b3",
                TipoDepartamento.RecursosHumanos));
        
        return entidades;
    }
}
