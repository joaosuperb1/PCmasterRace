/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package utils;

import Model.*;
import controller.JPAUtil;
import jakarta.persistence.EntityManager;

/**
 *
 * @author superbi
 */

public class PopularBD {

    public static void main(String[] args) {
        EntityManager em = JPAUtil.getEntityManager();

        try {
            em.getTransaction().begin();
            System.out.println("--- 1. Criando Pessoas (Necessário para Atendimentos) ---");

            // Técnicos
            Tecnico tec1 = new Tecnico();
            tec1.setNome("Carlos Técnico");
            tec1.setLogin("carlos");
            tec1.setSenha("123");
            em.persist(tec1);

            Tecnico tec2 = new Tecnico();
            tec2.setNome("João Reparador");
            tec2.setLogin("joao");
            tec2.setSenha("456");
            em.persist(tec2);

            Tecnico tec3 = new Tecnico();
            tec3.setNome("Ana Especialista");
            tec3.setLogin("ana");
            tec3.setSenha("789");
            em.persist(tec3);

            // Clientes
            Cliente cli1 = new Cliente();
            cli1.setNome("Maria Cliente");
            cli1.setLogin("maria");
            cli1.setSenha("123");
            cli1.setCpf("111.222.333-44");
            em.persist(cli1);

            Cliente cli2 = new Cliente();
            cli2.setNome("Pedro Silva");
            cli2.setLogin("pedro");
            cli2.setSenha("456");
            cli2.setCpf("222.333.444-55");
            em.persist(cli2);

            Cliente cli3 = new Cliente();
            cli3.setNome("Juliana Costa");
            cli3.setLogin("juliana");
            cli3.setSenha("789");
            cli3.setCpf("333.444.555-66");
            em.persist(cli3);

            Cliente cli4 = new Cliente();
            cli4.setNome("Roberto Alves");
            cli4.setLogin("roberto");
            cli4.setSenha("012");
            cli4.setCpf("444.555.666-77");
            em.persist(cli4);

            Cliente cli5 = new Cliente();
            cli5.setNome("Fernanda Lima");
            cli5.setLogin("fernanda");
            cli5.setSenha("345");
            cli5.setCpf("555.666.777-88");
            em.persist(cli5);

            // Gerentes
            Gerente gen1 = new Gerente();
            gen1.setNome("Ademiro");
            gen1.setLogin("admin");
            gen1.setSenha("123");
            gen1.setCpf("111.222.233-44");
            em.persist(gen1);

            Gerente gen2 = new Gerente();
            gen2.setNome("Patrícia Gerente");
            gen2.setLogin("patricia");
            gen2.setSenha("456");
            gen2.setCpf("666.777.888-99");
            em.persist(gen2);

            System.out.println("--- 2. Criando Peças (Estoque) ---");

            // Peças de Armazenamento
            Pecas peca1 = new Pecas();
            peca1.setBrand("Kingston");
            peca1.setModel("SSD 480GB");
            peca1.setCondicao("NOVO");
            peca1.setCodigo("SSD001");
            peca1.setQuant(15);
            peca1.setCusto(120.00);
            peca1.setPreco(250.00);
            em.persist(peca1);

            Pecas peca2 = new Pecas();
            peca2.setBrand("Samsung");
            peca2.setModel("SSD 1TB NVMe");
            peca2.setCondicao("NOVO");
            peca2.setCodigo("SSD002");
            peca2.setQuant(8);
            peca2.setCusto(280.00);
            peca2.setPreco(450.00);
            em.persist(peca2);

            Pecas peca3 = new Pecas();
            peca3.setBrand("Western Digital");
            peca3.setModel("HD 1TB");
            peca3.setCondicao("USADO");
            peca3.setCodigo("HD001");
            peca3.setQuant(5);
            peca3.setCusto(100.00);
            peca3.setPreco(180.00);
            em.persist(peca3);

            // Peças de Memória
            Pecas peca4 = new Pecas();
            peca4.setBrand("Corsair");
            peca4.setModel("DDR4 8GB 3200MHz");
            peca4.setCondicao("NOVO");
            peca4.setCodigo("RAM001");
            peca4.setQuant(20);
            peca4.setCusto(120.00);
            peca4.setPreco(220.00);
            em.persist(peca4);

            Pecas peca5 = new Pecas();
            peca5.setBrand("HyperX");
            peca5.setModel("DDR4 16GB 2666MHz");
            peca5.setCondicao("USADO");
            peca5.setCodigo("RAM002");
            peca5.setQuant(10);
            peca5.setCusto(150.00);
            peca5.setPreco(280.00);
            em.persist(peca5);

            // Fontes de Alimentação
            Pecas peca6 = new Pecas();
            peca6.setBrand("Corsair");
            peca6.setModel("CX650 80 Plus Bronze");
            peca6.setCondicao("NOVO");
            peca6.setCodigo("PSU001");
            peca6.setQuant(7);
            peca6.setCusto(220.00);
            peca6.setPreco(380.00);
            em.persist(peca6);

            Pecas peca7 = new Pecas();
            peca7.setBrand("EVGA");
            peca7.setModel("500W 80 Plus");
            peca7.setCondicao("USADO");
            peca7.setCodigo("PSU002");
            peca7.setQuant(4);
            peca7.setCusto(110.00);
            peca7.setPreco(190.00);
            em.persist(peca7);

            // Placas-mãe
            Pecas peca8 = new Pecas();
            peca8.setBrand("ASUS");
            peca8.setModel("B450M Gaming");
            peca8.setCondicao("NOVO");
            peca8.setCodigo("MOBO01");
            peca8.setQuant(6);
            peca8.setCusto(350.00);
            peca8.setPreco(580.00);
            em.persist(peca8);

            // Processadores
            Pecas peca9 = new Pecas();
            peca9.setBrand("Intel");
            peca9.setModel("Core i5 10400F");
            peca9.setCondicao("NOVO");
            peca9.setCodigo("CPU001");
            peca9.setQuant(5);
            peca9.setCusto(650.00);
            peca9.setPreco(950.00);
            em.persist(peca9);

            Pecas peca10 = new Pecas();
            peca10.setBrand("AMD");
            peca10.setModel("Ryzen 5 3600");
            peca10.setCondicao("USADO");
            peca10.setCodigo("CPU002");
            peca10.setQuant(3);
            peca10.setCusto(500.00);
            peca10.setPreco(780.00);
            em.persist(peca10);

            System.out.println("--- 3. Criando Dispositivos (Produtos/Estoque) ---");

            // Notebooks
            Dispositivos disp1 = new Dispositivos();
            disp1.setBrand("Dell");
            disp1.setModel("Inspiron 15 3000");
            disp1.setCodigo("NB001");
            disp1.setQuant(1);
            disp1.setCusto(1500.0);
            disp1.setPreco(2200.0);
            em.persist(disp1);

            Dispositivos disp2 = new Dispositivos();
            disp2.setBrand("Apple");
            disp2.setModel("MacBook Air M1");
            disp2.setCodigo("NB002");
            disp2.setQuant(1);
            disp2.setCusto(4500.0);
            disp2.setPreco(6000.0);
            em.persist(disp2);

            Dispositivos disp3 = new Dispositivos();
            disp3.setBrand("Lenovo");
            disp3.setModel("ThinkPad T480");
            disp3.setCodigo("NB003");
            disp3.setQuant(2);
            disp3.setCusto(1800.0);
            disp3.setPreco(2800.0);
            em.persist(disp3);

            // Smartphones
            Dispositivos disp4 = new Dispositivos();
            disp4.setBrand("Apple");
            disp4.setModel("iPhone 13");
            disp4.setCodigo("SP001");
            disp4.setQuant(1);
            disp4.setCusto(3000.0);
            disp4.setPreco(4200.0);
            em.persist(disp4);

            Dispositivos disp5 = new Dispositivos();
            disp5.setBrand("Samsung");
            disp5.setModel("Galaxy S21");
            disp5.setCodigo("SP002");
            disp5.setQuant(1);
            disp5.setCusto(2000.0);
            disp5.setPreco(2900.0);
            em.persist(disp5);

            Dispositivos disp6 = new Dispositivos();
            disp6.setBrand("Xiaomi");
            disp6.setModel("Redmi Note 10");
            disp6.setCodigo("SP003");
            disp6.setQuant(3);
            disp6.setCusto(800.0);
            disp6.setPreco(1400.0);
            em.persist(disp6);

            // Desktops
            Dispositivos disp7 = new Dispositivos();
            disp7.setBrand("HP");
            disp7.setModel("Pavilion Gaming");
            disp7.setCodigo("DT001");
            disp7.setQuant(1);
            disp7.setCusto(2500.0);
            disp7.setPreco(3800.0);
            em.persist(disp7);

            Dispositivos disp8 = new Dispositivos();
            disp8.setBrand("Acer");
            disp8.setModel("Nitro 50");
            disp8.setCodigo("DT002");
            disp8.setQuant(1);
            disp8.setCusto(2700.0);
            disp8.setPreco(4000.0);
            em.persist(disp8);

            // Tablets
            Dispositivos disp9 = new Dispositivos();
            disp9.setBrand("Apple");
            disp9.setModel("iPad Air 4");
            disp9.setCodigo("TB001");
            disp9.setQuant(2);
            disp9.setCusto(2200.0);
            disp9.setPreco(3300.0);
            em.persist(disp9);

            Dispositivos disp10 = new Dispositivos();
            disp10.setBrand("Samsung");
            disp10.setModel("Galaxy Tab S7");
            disp10.setCodigo("TB002");
            disp10.setQuant(1);
            disp10.setCusto(1900.0);
            disp10.setPreco(2800.0);
            em.persist(disp10);

            System.out.println("--- 4. Criando Atendimentos (Com Peças/Dispositivos) ---");

            // Atendimento 1
            Atendimento atend1 = new Atendimento();
            atend1.setCliente(cli1);
            atend1.setTecnico(tec1);
            atend1.setData_atendimento("01/12/2025");
            atend1.setStatus("CONCLUÍDO");
            atend1.setDescricao("Troca de tela e formatação do sistema.");
            atend1.setPreco("350.00");
            atend1.addDispositivo(disp1); 
            em.persist(atend1);

            // Atendimento 2
            Atendimento atend2 = new Atendimento();
            atend2.setCliente(cli2);
            atend2.setTecnico(tec2);
            atend2.setData_atendimento("02/12/2025");
            atend2.setStatus("EM ANDAMENTO");
            atend2.setDescricao("Substituição da bateria e limpeza interna.");
            atend2.setPreco("280.00");
            atend2.addDispositivo(disp4);
            em.persist(atend2);

            // Atendimento 3
            Atendimento atend3 = new Atendimento();
            atend3.setCliente(cli3);
            atend3.setTecnico(tec1);
            atend3.setData_atendimento("03/12/2025");
            atend3.setStatus("ABERTO");
            atend3.setDescricao("Upgrade de memória RAM para 16GB.");
            atend3.setPreco("220.00");
            atend3.addDispositivo(disp3);
            atend3.addPeca(peca4);
            em.persist(atend3);

            // Atendimento 4
            Atendimento atend4 = new Atendimento();
            atend4.setCliente(cli4);
            atend4.setTecnico(tec3);
            atend4.setData_atendimento("03/12/2025");
            atend4.setStatus("ABERTO");
            atend4.setDescricao("Diagnóstico de superaquecimento.");
            atend4.setPreco("80.00");
            atend4.addDispositivo(disp7);
            em.persist(atend4);

            // Atendimento 5
            Atendimento atend5 = new Atendimento();
            atend5.setCliente(cli5);
            atend5.setTecnico(tec2);
            atend5.setData_atendimento("02/12/2025");
            atend5.setStatus("CANCELADO");
            atend5.setDescricao("Recuperação de dados de HD danificado.");
            atend5.setPreco("500.00");
            atend5.addPeca(peca3);
            em.persist(atend5);

            // Atendimento 6
            Atendimento atend6 = new Atendimento();
            atend6.setCliente(cli1);
            atend6.setTecnico(tec3);
            atend6.setData_atendimento("04/12/2025");
            atend6.setStatus("AGUARDANDO PEÇAS");
            atend6.setDescricao("Troca da placa-mãe e fonte.");
            atend6.setPreco("650.00");
            atend6.addPeca(peca8);
            atend6.addPeca(peca6);
            em.persist(atend6);

            // Atendimento 7
            Atendimento atend7 = new Atendimento();
            atend7.setCliente(cli3);
            atend7.setTecnico(tec2);
            atend7.setData_atendimento("30/11/2025");
            atend7.setStatus("CONCLUÍDO");
            atend7.setDescricao("Instalação de SSD e reinstalação do Windows.");
            atend7.setPreco("300.00");
            atend7.addPeca(peca2);
            em.persist(atend7);

            // Atendimento 8
            Atendimento atend8 = new Atendimento();
            atend8.setCliente(cli2);
            atend8.setTecnico(tec1);
            atend8.setData_atendimento("28/11/2025");
            atend8.setStatus("CONCLUÍDO");
            atend8.setDescricao("Reparo no conector de carga e troca do módulo Wi-Fi.");
            atend8.setPreco("420.00");
            atend8.addDispositivo(disp6);
            em.persist(atend8);

            // Atendimento 9
            Atendimento atend9 = new Atendimento();
            atend9.setCliente(cli4);
            atend9.setTecnico(tec3);
            atend9.setData_atendimento("01/12/2025");
            atend9.setStatus("EM ANDAMENTO");
            atend9.setDescricao("Troca da tela trincada.");
            atend9.setPreco("850.00");
            atend9.addDispositivo(disp5);
            em.persist(atend9);

            // Atendimento 10
            Atendimento atend10 = new Atendimento();
            atend10.setCliente(cli5);
            atend10.setTecnico(tec1);
            atend10.setData_atendimento("04/12/2025");
            atend10.setStatus("ABERTO");
            atend10.setDescricao("Configuração de rede e instalação de softwares.");
            atend10.setPreco("150.00");
            atend10.addDispositivo(disp10);
            em.persist(atend10);
            
            System.out.println("--- 5. Criando Feedbacks ---");
            
            // O atend1 era do cli1
            Feedback feed1 = new Feedback("Ótimo serviço, o notebook ficou novo!", cli1); 
            em.persist(feed1);
            
            // O atend7 era do cli3
            Feedback feed2 = new Feedback("O atendimento foi rápido, mas achei o preço um pouco alto.", cli3);
            em.persist(feed2);
            
            // O atend8 era do cli2
            Feedback feed3 = new Feedback("Excelente profissional, resolveu o problema do wifi.", cli2);
            em.persist(feed3);

            // Finalizando
            em.getTransaction().commit();
            System.out.println("--- Banco povoado com Sucesso! ---");
            System.out.println("Total de registros criados:");
            System.out.println("- Pessoas: " + (3 + 5 + 2));
            System.out.println("- Peças: 10");
            System.out.println("- Dispositivos: 10");
            System.out.println("- Atendimentos: 10");
            System.out.println("- Feedbacks: 3");

        } catch (Exception e) {
            e.printStackTrace();
            if (em.getTransaction().isActive()) {
                em.getTransaction().rollback();
            }
        } finally {
            em.close();
            JPAUtil.close();
        }
    }
}