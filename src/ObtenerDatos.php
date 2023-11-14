<?php

if (isset($_GET['Token']) && isset($_GET['Listado'])) {
    if ($_GET['Token'] == "Correcaminos") {
        header('Content-Type: application/json');
        switch ($_GET['Listado']) {
            case 'estudiantes':
                echo json_encode(file_get_contents('./estudiantes.json'));
                break;
                case 'solicitudes_licencia_estudiante':
                    echo json_encode(file_get_contents('./solicitudes.json'));
                    break;
                    case 'responsabilidades_estudiante':
                        echo file_get_contents(file_get_contents('./responsabilidadesEstudiantes.json')) ;
                        break;
            default:
                echo null;
                break;
        }
    }
}