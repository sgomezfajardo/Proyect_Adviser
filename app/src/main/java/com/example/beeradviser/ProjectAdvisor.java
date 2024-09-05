package com.example.beeradviser;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class ProjectAdvisor {

    private static final Map<String, List<String>> projectMap = new HashMap<>();
    private static final Map<String, List<String>> detailedInterventionsMap = new HashMap<>();

    static {
        List<String> infraestructura = new ArrayList<>();
        infraestructura.add("Puentes");
        infraestructura.add("Zonas verdes");
        infraestructura.add("Vías");
        infraestructura.add("Semaforización");

        List<String> recreacion = new ArrayList<>();
        recreacion.add("Ciclovías");
        recreacion.add("Parques");

        List<String> necesidades = new ArrayList<>();
        necesidades.add("Hospitales");
        necesidades.add("Supermercados");
        necesidades.add("Farmacias");

        projectMap.put("Infraestructura", infraestructura);
        projectMap.put("Recreación", recreacion);
        projectMap.put("Necesidades", necesidades);

        // Adding detailed interventions
        List<String> vias = new ArrayList<>();
        vias.add("Vía Norte");
        vias.add("Vía Sur");
        vias.add("Vía Este");
        vias.add("Vía Oeste");

        List<String> parques = new ArrayList<>();
        parques.add("Parque Central");
        parques.add("Parque del Sur");
        parques.add("Parque de la Costa");

        detailedInterventionsMap.put("Vías", vias);
        detailedInterventionsMap.put("Parques", parques);
    }

    public List<String> getInterventions(String projectType) {
        return projectMap.getOrDefault(projectType, new ArrayList<>());
    }

    public List<String> getDetailedInterventions(String intervention) {
        return detailedInterventionsMap.getOrDefault(intervention, new ArrayList<>());
    }
}
