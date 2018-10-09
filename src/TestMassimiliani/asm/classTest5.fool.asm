push 0
push 1
push 1
push 1
push 4
push 3
push 2
push 4
push classPaperino
new
lfp
push 8
push 7
push -4
lfp
add
lw
copy
lw
push 0
add
lc
js
print
lfp
push 0
push -4
lfp
add
lw
copy
lw
push 1
add
lc
js
print
lfp
push -4
lfp
add
lw
copy
lw
push 2
add
lc
js
print
halt

function0:
cfp
lra
push 1
lfp
add
lw
push 2
push 0 
lfp
add
lw
calchoff
add
lw
add
srv
sra
pop
pop
pop
sfp
lrv
lra
js

function1:
cfp
lra
push 0
push -2
lfp
add
lw
srv
pop
sra
pop
pop
sfp
lrv
lra
js

function2:
cfp
lra
push 1
push 0 
lfp
add
lw
calchoff
add
lw
push 1
beq label0
push 4
push 0 
lfp
add
lw
calchoff
add
lw
b label1
label0:
push 3
push 0 
lfp
add
lw
calchoff
add
lw
label1:
srv
sra
pop
sfp
lrv
lra
js
classPaperino:
function0
function1
function2
classPippo:
function0
classPluto:
function0
function1
