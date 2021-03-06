/*
 * Copyright 2012 Steve Chaloner
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *     http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package controllers;

import actions.UpdateContext;
import be.objectify.deadbolt.java.actions.DeferredDeadbolt;
import be.objectify.deadbolt.java.actions.Dynamic;
import be.objectify.deadbolt.java.actions.Group;
import be.objectify.deadbolt.java.actions.Pattern;
import be.objectify.deadbolt.java.actions.Restrict;
import be.objectify.deadbolt.java.actions.SubjectNotPresent;
import be.objectify.deadbolt.java.actions.SubjectPresent;
import play.mvc.Controller;
import play.mvc.Result;
import views.html.accessOk;

import java.util.concurrent.CompletableFuture;
import java.util.concurrent.CompletionStage;

/**
 * @author Steve Chaloner (steve@objectify.be)
 */
@UpdateContext("Added before deferred Deadbolt actions")
@DeferredDeadbolt
public class DeferredController extends Controller
{
    @Restrict(value=@Group("foo"), deferred=true)
    public CompletionStage<Result> deferredRestrict()
    {
        return CompletableFuture.completedFuture(ok(accessOk.render()));
    }

    @Restrict(value=@Group({"foo", "bar"}), deferred=true)
    public CompletionStage<Result> deferredRestrictions()
    {
        return CompletableFuture.completedFuture(ok(accessOk.render()));
    }

    @Pattern(value = "printers.detonate", deferred=true)
    public CompletionStage<Result> deferredPattern()
    {
        return CompletableFuture.completedFuture(ok(accessOk.render()));
    }

    @Dynamic(value="pureLuck", deferred=true)
    public CompletionStage<Result> deferredDynamic()
    {
        return CompletableFuture.completedFuture(ok(accessOk.render()));
    }

    @SubjectPresent(deferred=true)
    public CompletionStage<Result> deferredSubjectPresent()
    {
        return CompletableFuture.completedFuture(ok(accessOk.render()));
    }

    @SubjectNotPresent(deferred=true)
    public CompletionStage<Result> deferredSubjectNotPresent()
    {
        return CompletableFuture.completedFuture(ok(accessOk.render()));
    }
}
