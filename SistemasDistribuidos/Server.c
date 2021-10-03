/*
 * (C) 2017 by JosÃ© MarÃ­a Foces MorÃ¡n and JosÃ© MarÃ­a Foces Vivancos
 *
 * Conceptual Computer Networks course book
 *
 * UDP Echo server: Expects a message 5 times and sends back a response to each
 *
 */

#include <stdio.h>
#include <stdlib.h>

#include <fcntl.h>
#include <memory.h>

#include <sys/types.h>
#include <sys/socket.h>
#include <netinet/in.h>
#include <arpa/inet.h>
#include <netdb.h>
#include <unistd.h>

#include <signal.h>
#include <errno.h>
#include <sys/time.h>

#define OURPORT 50500
#define REQLENGTH 127

char DATEREQUEST[REQLENGTH + 1];

int MAXITERATIONS = 5;


int main(int argc, char** argv) {

    /*
     * Crear la direcciÃ³n de la socket UDP
     */
    struct sockaddr_in server;
    // Socket del tipo 'internet'
    server.sin_family = AF_INET;
    // Elegimos un puerto no reservado
    server.sin_port = htons(OURPORT);
    /* Esta socket (En este server) va a a escuchar en
     * cualquiera de las IPs, reales o virtuales
     */
    server.sin_addr.s_addr = INADDR_ANY;

    /*
     * Se crea una socket internet, del tipo datagrama
     */
    int s;
    s = socket(AF_INET, SOCK_DGRAM, 0); //Ãšltimo arg, siempre 0


    /*
     * Unimos a la socket s la direcciÃ³n que hemos creado en los
     * pÃ¡rrafos anteriores:
     */
    bind(s, (struct sockaddr *) &server, sizeof (server));


    /*
     * DirecciÃ³n del cliente que nos va a contactar
     */
    struct sockaddr_in client;
    unsigned int addr_length;
    //addr_length = sizeof (client);

    printf("Servidor esperando a recibir una solicitud\n");
    fflush(stdout);


    /*
     * Usar la socket s para recibir un mensaje que se almacenarÃ¡ en DATEREQUEST y
     * que no serÃ¡ de longitud efectiva superior a REQLENGTH (20 bytes),
     * la direcciÃ³n y el puerto del cliente quedarÃ¡n registrados en client
     */
    addr_length = sizeof (client);
    int i = 0;

    while (i < MAXITERATIONS) {
        int nbytes = recvfrom(s, DATEREQUEST, REQLENGTH, 0, (struct sockaddr *) &client, &addr_length);

        printf("Solicitud recibida con un tamaÃ±o de %u bytes, procedentes de %s@ puerto %u:\n",
                nbytes, inet_ntoa(client.sin_addr), client.sin_port);

        printf("'%s'\n", DATEREQUEST);

        char *response = "Respuesta de prueba";

        /*
         * Usar la socket s para enviar un DATAGRAMA de respuesta al cliente desde
         * el que hemos recibido la solicitud
         */
        nbytes = sendto(s, response, strlen(response) + 1, 0, (struct sockaddr *) &client, sizeof (client));

        printf("Enviados %u bytes:\n\n", nbytes);

        i++;
    }
}