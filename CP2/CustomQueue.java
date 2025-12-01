//  https://chat.openai.com/ Se me dificultó mantener el orden correcto al agregar
//y sacar índices de la cola para que los índices se guarden y recuperen en el orden correcto.
public class CustomQueue {

    private QueueNode _head;

    public CustomQueue() {
        _head = null;
    }

    public void enqueue(int index) {
        var node = new QueueNode(index);

        if (_head == null) {
            _head = node;
        } else {
            QueueNode temp = _head;
            while (temp.getNext() != null) {
                temp = temp.getNext();
            }
            temp.setNext(node);
        }
    }

    public int dequeue() {
        int index = -1;

        if (_head != null) {
            index = _head.getIndex();
            _head = _head.getNext();
        }

        return index;
    }

    public int getSize() {
        int size = 0;

        QueueNode temp = _head;
        while (temp != null) {
            size++;
            temp = temp.getNext();
        }

        return size;
    }

    public String getIndexes() {
        var builder = new StringBuilder();
        for (var index = dequeue(); index > -1; index = dequeue()) {
            builder.append(" " + index);
        }
        return builder.toString();
    }
}
