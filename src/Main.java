import java.util.Scanner;
public class Main {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        Gastos gt = new Gastos();
        Ganhos gn = new Ganhos();
        InformeGastos relGastos = new InformeGastos();
        InformeGanhos relGanhos = new InformeGanhos();
        Total saldo = new Total();
        Datas data = new Datas();
        String pagamento = "";

        int count_gasto = 0;
        int count_ganho = 0;

        while(true) {
            System.out.println(" ");
            System.out.println("Finanças");
            System.out.println("1-Insira Gastos");
            System.out.println("2-Insira Ganhos");
            System.out.println("3-Relatório de Gastos");
            System.out.println("4-Relatório de Ganhos");
            System.out.println("5-Relatório Mensal");
            System.out.println("6-Feche o Software");
            System.out.println(" ");
            System.out.println("Selecione uma opção: ");
            int option = scan.nextInt();

            if (option == 6) {
                System.out.println("Desligando...!");
                return;
            }

            if (option == 1) {
                System.out.println("Insira o nome do gasto:");
                scan.nextLine();
                String nomeGasto = scan.nextLine();
                gt.setNomeGasto(nomeGasto, count_gasto);


                System.out.println("Insira o tipo do gasto:");
                String tipoGasto = scan.nextLine();
                gt.setTipoGasto(tipoGasto, count_gasto);


                System.out.println("Insira o dia:");
                int dia = scan.nextInt();
                System.out.println("Insira o mês:");
                int mes = scan.nextInt();


                data.setDia(dia);
                data.setMes(mes);

                data.setFormData(dia,mes,count_gasto);


                System.out.println("Insira o valor do gasto:");
                double valorGasto = scan.nextDouble();
                gt.setValorGasto(valorGasto, count_gasto);


                System.out.println("Insira a forma de pagamento do gasto:");
                System.out.println("1-PIX");
                System.out.println("2-Boleto");
                System.out.println("3-Credito");
                int pagamentoGasto = scan.nextInt();
                gt.setPagamentoGasto(pagamentoGasto, count_gasto);


                while (pagamentoGasto != 1 && pagamentoGasto != 2 && pagamentoGasto != 3) {
                    System.out.println("\n\nO valor inserido não é valido!");
                    System.out.println("1-PIX");
                    System.out.println("2-Boleto");
                    System.out.println("3-Credito");
                    pagamentoGasto = scan.nextInt();
                }

                System.out.printf("\n\n\n\n %30s: %15s","Nome",nomeGasto);
                System.out.printf("\n %30s: %15s","Tipo",tipoGasto);
                System.out.printf("\n %30s: %15s","Data",data.getFormData(count_gasto));
                System.out.printf("\n %30s: %15.2f","Valor",valorGasto);
                System.out.printf("\n %30s: %15s\n\n\n\n","Forma de Pagamento",pagamentoGasto);

                ++count_gasto;
            } else if (option == 2) {
                System.out.println("Insira o nome do ganho:");
                scan.nextLine();
                String nomeGanho = scan.nextLine();
                gn.setNomeGanho(nomeGanho, count_ganho);


                System.out.println("Insira o tipo do ganho:");
                String tipoGanho = scan.nextLine();
                gn.setTipoGanho(tipoGanho, count_ganho);


                System.out.println("Insira o dia:");
                int dia = scan.nextInt();
                System.out.println("Insira o mês:");
                int mes = scan.nextInt();

                data.setDia(dia);
                data.setMes(mes);
                data.setFormData(dia,mes,count_ganho);



                System.out.println("Insira o valor do ganho:");
                double valorGanho = scan.nextDouble();
                gn.setValorGanho(valorGanho, count_ganho);



                System.out.printf("\n\n\n\n %30s: %10s","Nome",nomeGanho);
                System.out.printf("\n %30s: %10s","Tipo",tipoGanho);
                System.out.printf("\n %30s: %10s","Data",data.getFormData(count_ganho));
                System.out.printf("\n %30s: %10.2f\n\n\n\n","Valor",valorGanho);

                ++count_ganho;
            } else {
                int i;
                if (option == 3) {
                    System.out.printf("%30s%15s%15s%15s%25s \n", "Gastos", "Tipo", "Data", "Valor", "Forma de Pagamento");
                    for (i = 0; i < count_gasto; ++i) {
                        if (gt.getPagamentoGasto(i) == 1) {
                            pagamento = "PIX";
                        } else if (gt.getPagamentoGasto(i) == 2) {
                            pagamento = "Boleto";
                        } else if (gt.getPagamentoGasto(i) == 3) {
                            pagamento = "Crédito";
                        }
                        relGastos.setRelatorio(gt.getNomeGasto(i), gt.getTipoGasto(i), data.getFormData(i), gt.getValorGasto(i), pagamento, i);
                        relGastos.getRelatorio(i);
                    }
                } else if (option == 4) {
                    System.out.printf("%30s%15s%15s%15s \n", "Ganhos", "Tipo", "Data", "Valor");

                    for (i = 0; i < count_ganho; ++i) {
                        relGanhos.setRelatorio(gn.getNomeGanho(i), gn.getTipoGanho(i), data.getFormData(i), gn.getValorGanho(i), i);
                        relGanhos.getRelatorio(i);
                    }
                } else if (option == 5) {
                    System.out.println("Escolha o mês do relatório:");
                    scan.nextLine();
                    int mensal = scan.nextInt();

                    System.out.printf("Gastos", "Tipo", "Data", "Valor", "Forma de Pagamento");
                    for (i = 0; i < count_gasto; ++i) {
                        if (data.getFormData(i).contains("/" + mensal )) {
                            if (gt.getPagamentoGasto(i) == 1) {
                                pagamento = "PIX";
                            } else if (gt.getPagamentoGasto(i) == 2) {
                                pagamento = "Boleto";
                            } else if (gt.getPagamentoGasto(i) == 3) {
                                pagamento = "Crédito";
                            }

                            relGastos.setRelatorio(gt.getNomeGasto(i), gt.getTipoGasto(i), data.getFormData(i), gt.getValorGasto(i), pagamento, i);
                            relGastos.getRelatorio(i);
                            saldo.setGastos(gt.getValorGasto(i));

                        } else {
                            System.out.printf("\n%100s", "Não existe registro de Gastos nesse mês!");
                        }
                    }

                    System.out.println("");
                    System.out.printf("Ganhos", "Tipo", "Data", "Valor");

                    for (i = 0; i < count_ganho; ++i) {
                        if (data.getFormData(i).contains("/" + mensal)) {
                            relGanhos.setRelatorio(gn.getNomeGanho(i), gn.getTipoGanho(i), data.getFormData(i), gn.getValorGanho(i), i);
                            relGanhos.getRelatorio(i);
                            saldo.setGanhos(gn.getValorGanho(i));

                        } else {
                            System.out.printf("\n%100s", "Não existe registro de Ganhos nesse mês!");
                        }
                    }
                    saldo.setsaldo();
                    saldo.getsaldo();
                }
            }
        }

    }
}