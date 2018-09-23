package br.com.cloudseven.bitcoin.facade;

/**
 * @author Marcos Pinho
 */
public interface JobFacade {

    void start(Long segundo);

    void stop();

}