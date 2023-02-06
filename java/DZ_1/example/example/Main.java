package DZ_1.example.example;

import java.util.*;

public class Main {

    public static void main(String[] args) {
        // ���� ��������� ����� � ��������
        // ������ ��� �������, ��� ����� ������������ �� �����
        // ����� ����� �����-�� �������
        // 2 ������ �� ����� ���������� � ����� ����� ������������
        // ������ ����� ����������� (������� ����� ������ (������������)),
        //              ������ ���� ������ ������ (��� ����� �� �����).

        Scanner userInput = new Scanner(System.in);

        System.out.println("����� ���������� � ����!");
        System.out.println("...��������...");

        RobotMap map;
        while (true) {
            System.out.println("��� �������� ����� ������� 2 ������������� ����� ����� ������");
            try {
                int n = userInput.nextInt();
                int m = userInput.nextInt();
                userInput.nextLine();

                map = new RobotMap(n, m);
                break;
            } catch (CreateMapValidationException | InputMismatchException e) {
                System.err.println("�������� ������ ��� �������� �����: " + e.getMessage());
            } catch (Throwable e) {
                System.err.println("�������� ������ �� ������� �������: " + e.getMessage());
                System.exit(1);
            }
        }

        System.out.println("����� ������� �������!");

        CommandManager commandManager = new CommandManager(map);

        System.out.println("��� ��������� ������ ���������� ������ ������� h");

        while (true) {
            System.out.println("������� �������");
            String command = userInput.nextLine();
            try {
                String commandExecutionResult = commandManager.handleCommand(command);
                if (Objects.nonNull(commandExecutionResult) && !commandExecutionResult.isBlank()) {
                    System.out.println(commandExecutionResult);
                }
            } catch (CommandNotFoundException e) {
                System.err.println("������� [" + e.getMessage() + "] �� �������");
            } catch (CommandExecutionException e) {
                System.err.println("�� ����� ���������� ������� ��������� ������: " + e.getMessage());
            }
        }

    }

    private static class CommandManager {

        private final RobotMap map;
        private final Map<String, CommandExecutor> commands;

        public CommandManager(RobotMap map) {
            this.map = map;

            commands = new HashMap<>();
            commands.put("h", this::printHelp);
            commands.put("q", this::quit);
            commands.put("a", this::addRobot);
            commands.put("l", this::listRobots);
            commands.put("m", this::moveRobot);
            commands.put("cd", this::changeDirection);
            // FIXME: 27.01.2023
        }

        public String handleCommand(String command) throws CommandNotFoundException, CommandExecutionException {
            String[] split = command.split(" ");
            String commandCode = split[0];

            CommandExecutor executor = commands.get(commandCode);
            if (executor == null) {
                throw new CommandNotFoundException(command);
            }

            String[] args = Arrays.copyOfRange(split, 1, split.length);
            return executor.execute(args);
        }

        private String addRobot(String[] args) throws CommandExecutionException {
            if (args.length < 2) {
                throw new CommandExecutionException("������������ ����������");
            }

            int x = Integer.parseInt(args[0]);
            int y = Integer.parseInt(args[1]);

            try {
                map.createRobot(new Point(x, y));
            } catch (RobotCreationException e) {
                throw new CommandExecutionException(e.getMessage());
            }

            return null;
        }

        private String listRobots(String[] args) throws  CommandExecutionException{
            // FIXME: 27.01.2023
            if(map.getRobots().size() == 0){
                throw  new CommandExecutionException("� ������ ��� �������!");
            }
            List<RobotMap.Robot> list =  map.getRobots();
            String l = "";
            for (int i = 0; i < list.size(); i++) {
                l+= list.get(i) + "\n";
            }

            return l;
        }
        private  String moveRobot(String[] args) throws CommandExecutionException{
            if(args.length>2){
                throw new CommandExecutionException("������������ ���������� ����������");
            }
            int index = Integer.parseInt(args[0]);
            int index2;
            try {
                 index2 = Integer.parseInt(args[1]);
                 RobotMap.Robot Robot = map.getRobots().get(index-1);
                try {
                    int step = index2;
                    if(index2 == 1 ){
                        Robot.move();
                    }else {
                        while (index2 > 0){
                            Robot.move(step);
                            index2--;
                        }
                    }

                } catch (RobotMoveException e) {
                    System.err.println("������ - " + e.getMessage());
                }
            } catch (ArrayIndexOutOfBoundsException e ){
                System.err.println("�� ���������� ���������");
            }



            return null;
        }
        private  String changeDirection(String[] args) throws CommandExecutionException {
            if(args.length>2){
                throw new CommandExecutionException("������������ ���������� ����������");
            }
            int index = Integer.parseInt(args[0]);
            if(index> map.getRobots().size() || index <= 0){
                throw  new CommandExecutionException("������ � ������� ["+ (index) +"]  �� ����������!");
            }

            try{
                RobotMap.Robot Robot = map.getRobots().get(index-1);
                System.out.println(Robot);
                Direction dir = Direction.valueOf(args[1]);
                Robot.changeDirection(dir);
            } catch (IllegalArgumentException e ){
                System.err.println("�������� �����������!");
            }





            return null;
        }

        private String printHelp(String[] args) {
            return """
                    h                  -> ����������� ������ ���������� ������ (help)
                    a 1 2              -> ������� ������ �� ������� (1, 2) (add)
                    l                  -> ����������� ���� ������� (list)
                    m id [5]           -> ���������� ������ �� 1 ������� ������ (move)
                    cd id [t, r, b, l] -> �������� ����������� ������ (change direction)
                    q                  -> ��������� ��������� (quit)
                    """;
        }

        private String quit(String[] args) {
            System.exit(0);
            return null;
        }

        private interface CommandExecutor {
            String execute(String[] args) throws CommandExecutionException;
        }

    }

    private void homework() {
        // �������� ��������� ������� move, change direction � list
    }

}
