package br.com.cloudseven.bitcoin.service;

/**
 * @author Marcos Pinho
 */
public interface ScheduleService {

    /**
     * Método que incializa o JOB
     * @param segundo informação não obrigatória, porém o usuário poderá definir de quanto
     *                em quanto tempo ele quer que a aplicação pegue mais informações atualiadas.
     */
    void start(Long segundo);

    /**
     * Método que para o JOB em execução
     */
    void stop();

}