package skillbox.javapro11.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import skillbox.javapro11.api.request.DialogRequest;
import skillbox.javapro11.api.response.CommonListResponse;
import skillbox.javapro11.api.response.CommonResponseData;
import skillbox.javapro11.api.response.DialogResponse;
import skillbox.javapro11.api.response.ResponseArrayUserIds;
import skillbox.javapro11.model.entity.Dialog;
import skillbox.javapro11.service.DialogsService;

/**
 * Created by timur_guliev on 27.04.2021.
 */
@RestController
@RequestMapping("/dialogs")
public class DialogsController {

    private DialogsService dialogsService;

    @Autowired
    public DialogsController(DialogsService dialogsService) {
        this.dialogsService = dialogsService;
    }

    @GetMapping("") //Сергей
    public ResponseEntity getDialogsList(@RequestParam(value = "query", defaultValue = "") String query,
                                         @RequestParam(value = "offset", defaultValue = "0") Integer offset,
                                         @RequestParam(value = "itemPerPage", defaultValue = "20") Integer itemPerPage) {

        CommonListResponse dialogsResponse = dialogsService.getDialogs(offset, itemPerPage, query);
        return new ResponseEntity<>(dialogsResponse, HttpStatus.OK);
    }

    @PostMapping("")
    public ResponseEntity createDialog(@RequestBody DialogRequest dialogRequest) {
        return new ResponseEntity<>(dialogsService.createDialog(dialogRequest), HttpStatus.OK);
    }

    @GetMapping("/unreaded") //Сергей
    public ResponseEntity getCountUnreadMessages() {
        CommonResponseData quantityUnreadMessage = dialogsService.getQuantityUnreadMessageOfPerson();
        return new ResponseEntity<>(quantityUnreadMessage, HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity deleteDialog(@PathVariable("id") long id) {
        return new ResponseEntity<>(dialogsService.deleteDialog(id), HttpStatus.OK);
    }

    @PutMapping("/{id}/users") //Сергей
    public ResponseEntity addUserIntoDialog(@PathVariable("id") long idDialog,
                                            @RequestBody DialogRequest dialogRequest) {

        ResponseArrayUserIds addUserIntoDialog = dialogsService.addUserIntoDialog(idDialog, dialogRequest);
        return new ResponseEntity<>(addUserIntoDialog, HttpStatus.OK);
    }

    @DeleteMapping("/{id}/users")
    public ResponseEntity deleteUserFromDialog(@PathVariable("id") long idDialog,
                                               @PathVariable("users_ids") String[] usersIds) {
        return new ResponseEntity<>(dialogsService.deleteUsersInDialog(idDialog, usersIds), HttpStatus.OK);
    }

    @GetMapping("/{id}/users/invite") //Сергей
    public ResponseEntity getInviteDialog(@PathVariable("id") long idDialog) {
        CommonResponseData linkInvite = dialogsService.getInviteDialog(idDialog);
        return new ResponseEntity<>(linkInvite, HttpStatus.OK);
    }

    @PutMapping("/{id}/users/join")
    public ResponseEntity joinToDialog() {
        return null;
    }

    @GetMapping("/{id}/messages") //Сергей
    public ResponseEntity getHistoryOfMessages(@PathVariable("id") long idDialog,
                                               @RequestParam(value = "query", defaultValue = "") String query,
                                               @RequestParam(value = "offset", defaultValue = "0") Integer offset,
                                               @RequestParam(value = "itemPerPage", defaultValue = "20") Integer itemPerPage) {

        CommonListResponse messageOfDialog = dialogsService.getMessageOfDialog(idDialog, offset, itemPerPage, query);
        return new ResponseEntity<>(messageOfDialog, HttpStatus.OK);
    }

    @PostMapping("/{id}/messages")
    public ResponseEntity sendMessages() {
        return null;
    }

    @DeleteMapping("/{dialog_id}/messages/{message_id}") //Сергей
    public ResponseEntity deleteMessage(@PathVariable("dialog_id") long idDialog,
                                        @PathVariable("message_id") long idMessage) {

        CommonResponseData message = dialogsService.deleteMessage(idMessage, idDialog);
        return new ResponseEntity<>(message, HttpStatus.OK);
    }

    @PutMapping("/{dialog_id}/messages/{message_id}")
    public ResponseEntity editMessage() {
        return null;
    }

    @PutMapping("/{dialog_id}/messages/{message_id}/recover") //Сергей
    public ResponseEntity recoverMessage(@PathVariable("dialog_id") long idDialog,
                                         @PathVariable("message_id") long idMessage) {

        CommonResponseData message = dialogsService.recoverMessage(idMessage, idDialog);
        return new ResponseEntity<>(message, HttpStatus.OK);
    }

    @PutMapping("/{dialog_id}/messages/{message_id}/read")
    public ResponseEntity readMessage() {
        return null;
    }

    @GetMapping("/{id}/activity/{user_id}") //Сергей
    public ResponseEntity getStatus(@PathVariable("id") long idDialog,
                                    @PathVariable("user_id") long idPerson) {

        CommonResponseData statusAndLastActivity = dialogsService.getStatusAndLastActivity(idPerson, idDialog);
        return new ResponseEntity<>(statusAndLastActivity, HttpStatus.OK);
    }

    @PostMapping("/{id}/activity/{user_id}")
    public ResponseEntity changeStatus() {
        return null;
    }

    @GetMapping("/longpoll") //Сергей
    public ResponseEntity getLongpoll() {
        return null;
    }

    @PostMapping("/longpoll/history")
    public ResponseEntity updateUserMessages() {
        return null;
    }
}
