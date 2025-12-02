/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package controller;
import Model.Atendimento;
import Model.Cliente;
import Model.Tecnico;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JOptionPane;
import view.TMcadAtendimento;

/**
 *
 * @author superbi


           
        //Dados Falsos Criados pelo Gemini:
        // 1. Crie alguns Clientes e Técnicos falsos para usar nos atendimentos
        // (Assumindo que Cliente e Tecnico têm construtores ou setters para o nome)
        
        Cliente cliente1 = new Cliente();
        cliente1.setNome("Ana Beatriz Costa");
        cliente1.setCpf("111.222.333-44");

        Cliente cliente2 = new Cliente();
        cliente2.setNome("Carlos Eduardo Lima");
        cliente2.setCpf("555.666.777-88");

        Tecnico tecnico1 = new Tecnico();
        tecnico1.setNome("Marcos Paulo Silva");

        Tecnico tecnico2 = new Tecnico();
        tecnico2.setNome("Juliana Ferreira");

        // 2. Crie os Atendimentos falsos
        Atendimento a1 = new Atendimento();
        a1.setId(proximoId++); // ID: 1
        a1.setData_atendimento("25/10/2025");
        a1.setCliente(cliente1);
        a1.setTecnico(tecnico1);
        a1.setStatus("Concluído");
        a1.setDescricao("Formatação de notebook Dell e instalação do Windows 11.");
        a1.setPreco("R$ 150,00");

        Atendimento a2 = new Atendimento();
        a2.setId(proximoId++); // ID: 2
        a2.setData_atendimento("28/10/2025");
        a2.setCliente(cliente2);
        a2.setTecnico(tecnico2);
        a2.setStatus("Em andamento");
        a2.setDescricao("Troca de tela de celular (iPhone 12). Peça encomendada.");
        a2.setPreco("R$ 750,00");
        
        Atendimento a3 = new Atendimento();
        a3.setId(proximoId++); // ID: 3
        a3.setData_atendimento("29/10/2025");
        a3.setCliente(cliente1); // Cliente Ana novamente
        a3.setTecnico(tecnico1);
        a3.setStatus("Aberto");
        a3.setDescricao("Backup de arquivos e limpeza de vírus em PC desktop.");
        a3.setPreco("R$ 100,00");

        // 3. Adicione os atendimentos ao "banco de dados falso"
        bancoDeDadosFalso.add(a1);
        bancoDeDadosFalso.add(a2);
        bancoDeDadosFalso.add(a3);
        
        System.out.println("HARD-CODED: Bloco estático executado, " + bancoDeDadosFalso.size() + " atendimentos de teste carregados.");
    }
    // --- FIM DO BLOCO ESTÁTICO ----
 */
    


public class AtendimentoController {

    // --- Nosso Banco de Dados Falso "Hard-Coded" ---
    private static final List<Atendimento> bancoDeDadosFalso = new ArrayList<>();
    private static int proximoId = 1;

    // --- Bloco de inicialização estático (com os dados falsos) ---
    static {
        // (Clientes e Técnicos falsos)
        Cliente cliente1 = new Cliente(); cliente1.setNome("Ana Beatriz Costa");
        Cliente cliente2 = new Cliente(); cliente2.setNome("Carlos Eduardo Lima");
        Tecnico tecnico1 = new Tecnico(); tecnico1.setNome("Marcos Paulo Silva");
        Tecnico tecnico2 = new Tecnico(); tecnico2.setNome("Juliana Ferreira");

        // (Atendimentos falsos)
        Atendimento a1 = new Atendimento(); a1.setId(proximoId++); a1.setData_atendimento("25/10/2025"); a1.setCliente(cliente1); a1.setTecnico(tecnico1); a1.setStatus("Concluído"); a1.setDescricao("Formatação de notebook Dell."); a1.setPreco("R$ 150,00");
        Atendimento a2 = new Atendimento(); a2.setId(proximoId++); a2.setData_atendimento("28/10/2025"); a2.setCliente(cliente2); a2.setTecnico(tecnico2); a2.setStatus("Em andamento"); a2.setDescricao("Troca de tela iPhone 12."); a2.setPreco("R$ 750,00");
        Atendimento a3 = new Atendimento(); a3.setId(proximoId++); a3.setData_atendimento("29/10/2025"); a3.setCliente(cliente1); a3.setTecnico(tecnico1); a3.setStatus("Aberto"); a3.setDescricao("Backup de arquivos e limpeza."); a3.setPreco("R$ 100,00");

        bancoDeDadosFalso.add(a1);
        bancoDeDadosFalso.add(a2);
        bancoDeDadosFalso.add(a3);
    }
    // --- Fim do Bloco Estático ---

    /**
     * Construtor (agora vazio).
     */
    public AtendimentoController() {
        // Não precisa mais do TableModel aqui!
    }

    /**
     * NOVO MÉTODO (ou renomeado): Apenas retorna a lista.
     * @return Uma cópia da lista de atendimentos.
     */
    public List<Atendimento> listarTodos() {
        System.out.println("GERENCIADOR: Listando todos... " + bancoDeDadosFalso.size() + " encontrados.");
        return new ArrayList<>(bancoDeDadosFalso); // Retorna uma cópia
    }

    /**
     * Salva ou Atualiza um atendimento na lista.
     */
    public void salvarAtendimento(Atendimento atendimento) {
        try {
            if (atendimento.getCliente() == null || atendimento.getTecnico() == null) {
                JOptionPane.showMessageDialog(null, "Cliente e Técnico são obrigatórios.", "Erro de Validação", JOptionPane.ERROR_MESSAGE);
                return;
            }
            
            if (atendimento.getId() == 0) {
                atendimento.setId(proximoId++); 
                bancoDeDadosFalso.add(atendimento);
                JOptionPane.showMessageDialog(null, "Atendimento salvo com sucesso!");
            } else {
                for (int i = 0; i < bancoDeDadosFalso.size(); i++) {
                    if (bancoDeDadosFalso.get(i).getId() == atendimento.getId()) {
                        bancoDeDadosFalso.set(i, atendimento);
                        JOptionPane.showMessageDialog(null, "Atendimento atualizado com sucesso!");
                        return; // Sai do método
                    }
                }
            }
            // *** A LINHA 'atualizarTabela()' FOI REMOVIDA DAQUI ***
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Erro ao salvar: " + e.getMessage(), "Erro", JOptionPane.ERROR_MESSAGE);
        }
    }

    /**
     * Exclui um atendimento da lista.
     */
    public void excluirAtendimento(Atendimento atendimento) {
        if (atendimento == null) { /* ... (validação) ... */ return; }
        
        int confirm = JOptionPane.showConfirmDialog(null, "Tem certeza?", "Confirmar", JOptionPane.YES_NO_OPTION);

        if (confirm == JOptionPane.YES_OPTION) {
            bancoDeDadosFalso.removeIf(at -> at.getId() == atendimento.getId());
            JOptionPane.showMessageDialog(null, "Atendimento excluído com sucesso!");
            // *** A LINHA 'atualizarTabela()' FOI REMOVIDA DAQUI ***
        }
    }
}