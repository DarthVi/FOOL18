push 0
push 4
push 1
push classpluto
new
lfp
push -2
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
push -2
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
halt

function0:
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
add
srv
sra
pop
sfp
lrv
lra
js

function1:
cfp
lra
push 1
srv
sra
pop
sfp
lrv
lra
js

function3:
cfp
lra
push 1
lfp
add
lw
srv
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
push 2
add
srv
sra
pop
sfp
lrv
lra
js
classpluto:
function2
function1
function3
classpippo:
function0
function1
classnull:
